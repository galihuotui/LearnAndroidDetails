package com.cky.learnandroiddetails.ViewPagerAdapterExtract;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

/**
 * Created by cuikangyuan on 2017/7/28.
 */

public abstract class LoopPagerAdapterExtracted extends PagerAdapter{

    private RollPagerView mViewPager;

    private ArrayList<View> mViewList = new ArrayList<>();

    public LoopPagerAdapterExtracted(RollPagerView viewPager) {
        this.mViewPager = viewPager;
    }

    @Override
    public int getCount() {
        if (getRealCount() <= 1) {
            return getRealCount();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = position % getRealCount();
        View itemView = findViewByPosition(container,realPosition);
        container.addView(itemView);
        return itemView;
    }

    private View findViewByPosition(ViewGroup container,int position){
        for (View view : mViewList) {
            if (((int)view.getTag()) == position && view.getParent() == null){
                return view;
            }
        }
        View view = getView(container,position);
        view.setTag(position);
        mViewList.add(view);
        return view;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void notifyDataSetChanged() {
        mViewList.clear();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


    public abstract View getView(ViewGroup container, int position);
    public abstract int getRealCount();
}
