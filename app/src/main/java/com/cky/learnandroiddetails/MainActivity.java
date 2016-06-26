package com.cky.learnandroiddetails;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvTest;
    Button btnStartService;
    Button btnStartIntentService;
    Button btnCountService;

    private MyService.DownloadBinder mDownloadBinder;

    private static final String TAG = MainActivity.class.getSimpleName();

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (MyService.DownloadBinder) service;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTest = (TextView) findViewById(R.id.tvTest);
        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStartIntentService = (Button)findViewById(R.id.btnStartIntentService);
        btnCountService = (Button)findViewById(R.id.btnStartCountService);
        /*
        * 1.子线程 更新 UI 控件
        * */
        new Thread(new Runnable() {
            @Override
            public void run() {
                tvTest.setText("How Are You ?");
            }
        }).start();

        btnStartService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
        btnCountService.setOnClickListener(this);
        /*
        * 2.活动 和 服务绑定
        *
        Intent bindIntent = new Intent(this, MyService.class);
        /*
        *BIND_AUTO_CREATE 活动和服务进行绑定之后 自动创建服务 服务的onCreate会执行 onStartCommand方法不执行
        bindService(bindIntent, mConnection, BIND_AUTO_CREATE);//绑定服务
        startService(bindIntent);
        */
        //unbindService(mConnection);//解绑服务

        /*
        * 后台计时服务
        *
        Intent i = new Intent(this, LongRunningService.class);
        startService(i);
        */
        /*
        Intent i = new Intent(this, MyService.class);
        startService(i);
        */

        /*字源查询

        var font = "啊阿埃挨哎唉哀皑癌蔼矮艾碍爱隘鞍氨安俺按暗岸胺案肮昂盎凹敖熬翱袄傲奥懊澳芭捌扒叭吧笆八疤巴拔跋靶把耙坝霸罢爸白柏百摆佰败拜稗斑班搬扳般颁板版扮拌伴瓣半办绊邦帮梆榜膀绑棒磅蚌镑谤苞胞包褒剥薄雹保堡饱宝抱报暴豹鲍爆杯碑悲卑北辈背贝倍狈备惫焙被奔苯本笨崩绷甭泵蹦迸逼鼻比鄙笔彼碧蓖蔽毕毙毖币庇痹闭敝弊必辟壁臂避陛鞭边编贬扁便变辨辩辫遍标彪膘表鳖憋别瘪彬斌濒滨宾摈兵冰柄丙秉饼炳病并玻菠播拨钵波博勃搏铂箔伯帛舶脖膊渤泊驳捕卜哺补埠不布步簿部怖擦猜裁材才财睬踩采彩菜蔡餐参蚕残惭惨灿苍舱仓沧藏操糙槽曹草厕策侧册测层蹭插叉茬茶查碴搽察岔差诧拆柴豺搀掺蝉馋谗缠铲产阐颤昌猖场尝常长偿肠厂敞畅唱倡超抄钞朝嘲潮巢吵炒车扯撤掣彻澈臣辰尘晨忱沉陈趁衬撑称城橙成呈乘程惩澄诚承逞骋秤吃痴持匙池迟驰耻齿侈尺赤翅斥炽充冲虫崇宠抽酬畴踌稠愁筹仇绸瞅丑臭初出橱厨躇锄雏除楚础储矗触处揣川穿椽传船喘串疮窗幢床闯创吹炊捶锤垂春椿醇唇淳纯蠢戳绰疵茨磁雌辞慈瓷词此刺赐次聪葱囱匆从丛凑粗醋簇促蹿篡窜摧崔催脆瘁粹淬翠村存寸磋撮搓措挫错搭达答瘩打大呆歹傣戴带殆代贷袋待逮怠耽担丹单掸胆旦氮但惮淡诞弹蛋当挡党荡档刀捣蹈倒岛祷导到稻悼道盗德得的蹬灯登等瞪凳邓堤低滴迪敌笛狄涤翟嫡抵底地蒂第帝弟递缔颠掂滇碘点典靛垫电佃甸店惦奠淀殿碉叼雕凋刁掉吊钓调跌爹碟蝶迭谍叠丁盯叮钉顶鼎锭定订丢东冬董懂动栋侗恫冻洞兜抖斗陡豆逗痘都督毒犊独读堵睹赌杜镀肚度渡妒端短锻段断缎堆兑队对墩吨蹲敦顿囤钝盾遁哆多夺垛躲朵跺舵剁惰堕蛾峨鹅俄额讹娥恶厄扼遏鄂饿恩而儿耳尔饵二贰发罚筏伐乏阀法珐藩帆番翻樊矾钒繁凡烦反返范贩犯饭泛坊芳方肪房防妨仿访纺放菲非啡飞肥匪诽吠肺废沸费芬酚吩氛分纷坟焚汾粉奋份忿愤粪丰封枫蜂峰锋风疯烽逢冯缝讽奉凤佛否夫敷肤孵扶拂辐幅符伏俘服浮福袱弗甫抚辅俯釜斧脯腑府腐赴副覆赋复傅付阜父腹负富讣附妇缚咐嘎该改概钙盖溉干甘杆柑竿肝赶感秆敢赣冈刚钢缸肛纲岗港杠篙高膏羔糕搞镐稿告哥歌搁戈鸽胳疙割革葛格蛤阁隔铬个各给根跟耕更庚羹埂耿梗工攻功恭龚供躬公宫弓巩汞拱贡共钩勾沟苟狗垢构购够辜菇咕箍估沽孤姑鼓古蛊骨谷股故顾固雇刮瓜剐寡挂褂乖拐怪棺关官冠观管馆罐惯灌贯光广逛瑰规圭硅归龟闺轨鬼诡癸桂柜跪贵刽辊滚棍锅郭国果裹过哈骸孩海亥害骇酣憨韩含涵寒函喊罕翰撼旱憾悍焊汗汉夯杭航壕嚎豪毫郝好耗号浩呵喝荷核禾和何合盒貉阂河涸赫褐鹤贺嘿黑痕很狠恨哼亨横衡恒轰哄烘虹鸿洪宏弘红喉侯猴吼厚候后呼乎忽瑚壶葫胡蝴狐湖弧虎唬护互沪户花哗华猾滑画划化话槐徊怀淮坏欢环还缓换患唤痪豢焕涣宦幻荒慌黄磺蝗簧皇凰惶煌晃幌恍谎灰挥辉徽恢蛔回毁悔慧卉惠晦贿秽会烩汇讳诲绘荤昏婚魂浑混豁活伙火获或惑霍货祸击圾基机畸稽积箕肌饥迹激讥鸡姬绩缉吉极棘辑籍集及急疾即嫉级挤几己技冀季伎祭剂悸济寄寂计记既忌际继纪嘉枷夹佳家加荚颊贾甲钾假稼价架驾嫁歼监坚尖笺间煎兼肩艰奸茧检柬碱拣捡简俭剪减荐槛鉴践贱见键箭件健舰剑饯渐溅涧建僵姜将浆江疆蒋桨奖讲匠酱降蕉椒礁焦胶交郊浇骄娇嚼搅矫侥脚狡角饺缴绞剿教酵轿较叫窖揭接皆秸街阶截劫节茎睛晶鲸京惊精粳经井警景颈静境敬镜径痉靖竟竞净炯窘揪究纠玖韭久灸九酒厩救旧臼舅咎就疚鞠拘狙疽居驹菊局咀矩举沮聚拒据巨具距踞锯俱句惧炬剧捐鹃娟倦眷卷绢攫掘倔爵桔杰捷睫竭洁结解姐戒芥界借介疥诫届巾筋斤金今津襟紧锦仅谨进晋禁近浸尽劲荆兢觉决诀绝均菌钧军君峻俊竣郡骏喀咖卡咯开揩楷凯慨刊堪勘坎砍看康慷糠扛抗亢炕考拷烤靠坷苛柯棵磕颗科壳咳可渴克刻客课肯啃垦恳坑吭空恐孔控抠口扣寇枯哭窟苦酷库裤夸垮挎跨胯块筷侩快宽款匡筐狂框矿眶旷况亏盔窥葵奎魁傀馈愧溃坤昆捆困括扩廓阔垃拉喇蜡腊辣啦莱来赖蓝婪栏拦篮阑兰澜谰揽览懒缆烂滥琅榔狼廊郎朗浪捞劳牢老佬姥酪烙涝勒乐雷镭蕾磊累儡垒擂肋类泪棱楞冷厘梨犁黎篱狸离漓理李里鲤礼莉荔吏栗丽厉励砾历利例俐痢立粒沥隶力璃哩俩联莲连镰廉怜涟帘敛脸链恋炼练粮凉梁良两辆量晾亮谅撩聊僚疗燎寥辽潦了撂镣料列裂烈劣猎琳林磷霖临邻鳞淋凛赁吝拎玲菱零龄铃伶羚凌灵陵岭领另令溜琉榴硫馏留刘瘤流柳六龙聋咙笼窿隆垄拢陇楼娄搂篓漏陋芦卢颅庐炉掳卤虏鲁麓碌露路赂鹿禄录陆戮驴吕铝侣旅履屡缕虑氯律率滤绿峦挛孪卵乱掠略抡轮伦仑沦纶论萝螺罗逻锣箩骡裸落洛骆络妈麻玛码蚂马骂嘛吗埋买麦卖迈脉瞒馒蛮满蔓曼慢漫谩芒茫盲氓忙莽猫茅锚毛矛铆卯茂冒帽貌贸么玫枚梅酶霉煤没眉媒镁每美昧寐妹媚门闷们萌蒙檬盟锰梦孟眯靡迷谜弥米秘觅泌蜜密幂棉眠绵冕免勉娩缅面苗描瞄藐秒渺庙妙蔑灭民抿皿敏悯闽明螟鸣铭名命谬摸摹蘑模膜磨摩魔抹末莫墨默沫漠寞陌谋牟某拇牡亩姆母墓暮幕募慕木目睦牧穆拿哪呐钠那娜纳乃奶耐奈南男难囊挠脑恼闹淖呢馁内嫩能妮霓倪泥尼拟你匿腻逆溺蔫拈年碾撵捻念娘酿鸟尿捏聂孽啮镊镍您柠狞凝宁拧泞牛扭钮纽脓浓农弄奴努怒女暖虐疟挪懦糯诺哦欧鸥殴藕呕偶沤啪趴爬帕怕琶拍排牌徘湃派攀潘盘磐盼畔判叛乓庞旁胖抛咆刨炮袍跑泡呸胚培裴赔陪配佩沛喷盆砰抨烹澎彭蓬棚硼篷膨朋鹏捧碰坯砒霹批披琵毗啤脾疲皮匹痞僻屁譬篇偏片骗飘漂瓢票撇瞥拼频贫品聘乒坪苹萍平凭瓶评屏坡泼颇婆破魄迫粕剖扑铺仆葡菩蒲埔朴圃普浦谱曝瀑期欺栖戚妻七凄漆柒沏其棋奇歧畦崎脐齐旗祈骑起岂乞企启契砌器气迄弃汽泣讫掐洽牵钎铅千迁签仟谦乾黔钱钳前潜遣浅谴堑嵌欠歉枪呛腔羌墙蔷强抢橇锹敲悄桥瞧乔侨巧鞘撬翘峭俏窍切茄且怯窃钦侵亲秦琴勤芹擒禽寝沁青轻氢倾卿清擎晴情顷请庆琼穷秋丘邱球求囚酋泅趋区蛆曲躯屈驱渠取娶趣去圈颧权泉全痊拳犬券劝缺瘸却鹊榷确雀裙群然燃冉染瓤壤攘嚷让饶扰绕惹热壬仁人忍韧任认刃妊纫扔仍日戎茸蓉荣融熔溶容绒冗揉柔肉茹蠕儒孺如辱乳汝入褥软阮蕊瑞锐闰润若弱撒洒萨腮鳃塞赛三叁伞散桑嗓丧搔骚扫嫂瑟色涩森僧莎砂杀刹沙纱傻啥煞筛晒珊苫杉山删煽衫闪陕擅赡膳善汕扇缮伤商赏晌上尚裳梢捎稍烧芍勺韶少哨邵绍奢赊蛇舌舍赦摄射慑涉社设申呻伸身深娠绅神沈审婶甚肾慎渗声生甥牲升绳省盛剩胜圣师失狮施湿诗尸虱十石拾时什食蚀实识史矢使屎驶始式示士世柿事拭誓逝势是嗜噬适仕侍释饰氏市恃室视试收手首守寿授售受瘦兽蔬枢梳殊抒输叔舒淑疏书赎孰熟薯暑曙署蜀黍鼠属术述树束戍竖墅庶数漱恕刷耍摔衰甩帅栓拴霜双爽谁水睡税吮瞬顺舜说硕朔烁斯撕嘶思私司丝死肆寺嗣四伺似饲巳松耸怂颂送宋讼诵搜艘擞嗽苏酥俗素速粟塑溯宿诉肃酸蒜算虽隋随绥髓碎岁穗遂隧孙损笋蓑梭唆缩琐索锁所塌他它她塔獭挞蹋踏胎苔抬台泰酞太态汰坍摊贪瘫滩坛檀痰潭谭谈坦毯袒碳探叹炭汤塘搪堂棠膛唐糖倘躺淌趟烫掏涛滔萄桃逃淘陶讨套特藤腾疼誊梯剔踢提题蹄啼体替嚏惕涕剃屉天添填田甜恬舔腆挑条迢眺跳贴铁帖厅听汀廷停亭庭挺艇通桐瞳同铜彤童桶捅筒统痛偷投头透凸秃突图徒途涂屠土吐兔湍团推颓腿蜕褪退吞屯臀拖托脱鸵陀驮驼椭妥拓唾挖哇蛙洼娃瓦袜歪外豌弯湾玩顽丸烷完碗挽晚皖惋宛婉万腕汪王亡枉网往旺望忘妄威巍微危韦违桅围唯惟为维苇萎委伟伪尾纬未蔚味畏胃喂魏位渭谓尉慰卫瘟温蚊文闻纹吻稳紊问嗡翁瓮蜗涡窝我斡卧握沃巫呜钨乌污诬屋无芜梧吾吴毋武五捂午舞伍侮坞戊雾晤物勿务悟误昔熙析西矽晰嘻吸锡牺稀息希悉膝夕惜熄烯溪汐犀檄袭席习媳喜铣洗系隙戏细瞎虾匣霞辖暇峡侠狭下厦夏吓掀锨先仙鲜纤咸贤衔舷闲涎弦嫌显险现献县腺馅羡宪陷限线相厢镶香箱湘乡翔祥详想响享项巷橡像向象萧硝霄削哮嚣销消宵淆晓小孝校肖啸笑效楔些歇蝎鞋协挟携邪斜胁谐写械卸蟹懈泄泻谢屑薪芯锌欣辛新心信衅星腥猩惺兴刑型形邢行醒幸杏性姓兄凶胸匈汹雄熊休修羞朽嗅锈秀袖绣墟戌需虚嘘须徐许蓄酗叙旭序畜恤絮婿绪续轩喧宣悬旋玄选癣眩绚靴薛学穴雪血勋熏循旬询寻驯巡殉汛训讯逊迅压押鸦鸭呀丫芽牙蚜崖衙涯雅哑亚讶焉咽阉烟淹盐严研蜒岩延言颜阎炎沿奄掩眼衍演艳堰燕厌砚雁唁彦焰宴谚验殃央鸯秧杨扬佯疡羊洋阳氧仰痒养样漾邀腰妖瑶摇尧遥窑谣姚咬舀药要耀椰噎耶爷野冶也页掖业叶曳腋夜液一壹医揖铱依伊衣颐夷遗移仪胰疑宜姨彝椅蚁倚已乙矣以艺抑易邑屹亿役臆逸肄疫亦裔意毅忆义益溢诣议谊译异翼翌绎茵荫因殷音阴姻吟银淫寅饮尹引隐印英樱婴鹰应莹萤营荧蝇迎赢盈影颖硬映哟拥佣臃痈庸雍踊蛹咏泳涌永恿勇用幽优悠忧尤由邮铀犹油游酉有友右佑釉诱又幼迂淤于盂榆虞愚舆余俞逾鱼愉渝渔隅予娱雨与屿禹宇语羽玉域芋郁吁遇喻峪御愈欲狱育誉浴寓裕预豫驭鸳渊冤元垣袁原援辕园员圆猿源缘远苑愿怨院曰约越跃钥岳粤月悦阅云匀陨允运蕴酝晕韵孕匝砸杂栽哉灾宰载再在咱攒暂赞赃脏葬遭糟凿藻枣早澡蚤躁噪造皂灶燥责择则泽贼怎增憎曾赠扎喳渣札轧铡闸眨栅榨咋乍炸诈摘斋宅窄债寨瞻毡詹粘沾盏斩辗崭展蘸栈占战站湛绽樟章彰张掌涨杖丈帐账仗胀瘴障招昭找沼赵照罩兆肇召遮折哲蛰辙者蔗这浙珍斟真甄砧臻贞针侦枕疹诊震振镇阵蒸挣睁征狰争怔整拯正政帧症郑证芝枝支吱蜘知肢脂汁之织职直植殖执值侄址指止趾只旨纸志挚掷至致置帜峙制智秩稚质炙痔滞治窒中盅忠钟衷终种肿重仲众舟周州洲诌粥轴肘帚咒皱宙昼骤珠株蛛朱猪诸诛逐竹烛煮拄瞩嘱主著柱助蛀贮铸筑住注祝驻抓爪拽专砖转撰赚篆桩庄装妆撞壮状椎锥追赘坠缀谆准捉拙卓桌琢茁酌啄着灼浊兹咨资姿滋孜紫仔籽滓子自渍字鬃棕踪宗综总纵走奏揍租足卒族祖诅阻组钻纂嘴醉最罪尊遵昨左佐柞做作坐座峥叨恰蜓筝蜻橘匕丐夭叽吆凫阱芙杈岖鸠沐妓姊卦拗茉昙肴衩玷茴荞荠盹咧昵咪秕胧奕飒炫祠荸莺桦唠蚣蚪蚓唧秫麸捺匾蚯蛉啰铐铛笙笤偎徙翎庵涮悴裆谒雳跛锉掰牍腌猬愕鹉蒿榄楣嗦跷蜈嗤馍禀缤榛榕嘁嘀幔箫漩橄嘹蝠蝌蝙鲫憔翩嬉缭薇噩蟥霎踱蹂蟆螃鹦瘾缰檐檩瞭蟋蟀朦臊鳄鳍癞簸鬓躏嫒霭谙犴桉鹌黯坳嗷遨媪骜螯鏖呗癍舨浜葆煲鸨褓孛陂埤蓓悖畚贲锛嘣愎弼妣婢裨筚篦弁汴砭褊鳊婊骠飑飙镖镳裱鳔蹩槟殡摒擘礴钹逋钚嚓孱骖粲伧嘈恻涔汊姹楂侪钗谄忏潺婵禅蟾伥鬯徜怅娼嫦昶鲳坼龀丞瞠叱哧啻饬媸敕鸱褫蚩螭笞豉踟魑忡憧铳舂惆瘳雠刍怵憷绌杵褚蜍黜啜踹怆陲棰槌莼鹑辍踔龊鹚糍淙琮辏腠猝蹙蹴撺萃啐璀毳隹忖皴厝嵯鹾蹉耷哒嗒怛褡呔迨骀黛啖殚眈疸瘅箪宕噔戥镫氐诋谛邸荻娣柢镝巅钿癫踮貂喋牒耋仃玎腚碇酊咚胴蔸嘟渎椟蠹笃黩椴沌炖咄铎裰萼呃屙婀腭锇颚摁迩珥垡砝蕃梵芾狒妃绯斐扉痱蜚翡霏棼俸缶匐孚驸赙稃馥蜉蝮尬尜赅坩尴擀疳睾诰槔杲鬲嗝膈镉袼舸亘哏艮哽鲠肱佝诟遘媾枸篝诂汩梏轱牯钴锢痼酤鹘呱倌盥鹳矜鳏犷胱桧炅晷皈簋鲑鳜鲧埚掴帼椁聒蜾蝈嗨瀚颔鼾沆颃嗥昊皓劾壑嗬阖盍颌翮桁黉讧薨泓後逅唿囫猢怙惚浒琥扈鹄醐骅踝獾漶寰徨遑璜肓篁诙荟蕙咴哕喙洄彗恚馄夥镬亟佶偈诘屐骥玑楫戟戢犄羁嵇稷笈暨跽霁髻浃迦戛胛铗痂蛱笳袈谏蹇缣楗犍毽锏裥翦趼绛犟佼噍徼姣皎蛟醮跤讦拮喈孑碣疖颉蚧羯噤妗瑾儆憬泾旌迥啾柩桕鹫赳倨讵苣苴掬遽屦榉飓裾趄龃瞿狷涓蠲镌隽厥噱崛獗孓珏橛蹶皲麇忾恺铠锴侃戡龛瞰伉犒嗑恪溘骒珂轲瞌稞疴窠颏裉铿蔻叩眍刳骷狯脍圹哐匮揆喟愦逵睽聩蝰篑跬阃鲲髡邋瘌徕籁岚褴螂痨嫘檑耒愣俪俚莅呖唳喱猁逦娌骊枥栎戾罹锂鹂疠笠粝醴潋殓裢裣蠊鲢踉靓魉寮冽捩洌趔嶙廪懔遴粼麟囹绫棂瓴聆鲮骝熘镏鎏茏珑栊砻癃偻喽镂瘘髅噜闾璐橹轳辘鸬鹭褛鲈鸾銮囵荦摞猡脶犸嬷霾颟螨鳗蟒袤牦耄髦麽莓鹛袂魅扪焖懑懵虻蜢蠓谧猕弭麋腼黾喵邈缈缪杪咩篾泯冥茗溟瞑酩蓦殁秣侔哞眸钼衲艿柰喃囝囡楠腩蝻馕孬猱瑙蛲讷恁嗯伲怩旎睨廿辇黏鲇袅乜臬蹑佞苎咛忸妞侬哝弩驽傩喏喔噢讴怄葩杷俳襻蹒彷滂狍庖脬疱辔怦丕圮媲纰枇睥罴铍癖蚍蜱骈犏胼剽嫖缥瞟螵拚姘嫔牝颦娉枰叵珀钋钷匍噗璞蹼芪葺汔淇骐绮琪琦杞耆祺憩蹊麒倩阡芡茜掮悭慊骞缱钤虔戕嫱樯锵镪襁跄诮愀樵惬妾挈锲箧揿噙檠磬罄黥穹湫遒赇虬裘鳅诎劬衢觑祛蛐诠荃绻辁铨蜷筌阕阙逡苒髯仞荏葚饪稔衽嵘蝾糅濡缛朊睿卅挲颡啬穑铩痧裟鲨讪姗嬗膻钐疝蟮舢跚鳝觞蛸艄猞歙麝莘椹莳轼舐筮豕鲥狩绶倏塾菽纾殳唰闩孀铄厮兕咝澌姒驷祀鸶耜嵩忪悚淞竦叟嗖馊飕夙愫簌谇邃燧荪狲榫隼唢娑遢榻沓鳎肽钛忐傥樘镗螳啕韬饕忑倜醍殄佻窕蜩龆餮婷铤霆嗵恸荼钍氽饨豚佗沱砣跎佤娲剜纨绾蜿罔惘魍诿帷崴猥闱逶娓玮炜煨刎汶雯倭莴幄龌兀庑忤寤迕妩骛焐鹜痦鋈鼯兮葸奚唏阋屣玺曦欷熹禧皙舾羲粞翕呷狎遐瑕黠苋藓娴鹇痫籼跣饷庠骧飨潇逍骁绡枭魈偕亵燮瀣邂榭囟馨鑫陉荇擤悻咻岫馐溴诩栩煦胥糈萱渲璇暄谑鳕巽埙薰峋曛醺鲟伢揠娅俨偃湮妍嫣晏胭筵酽魇餍鼹徉怏炀烊恙鞅爻徭幺杳鹞窈靥揶烨刈劓懿薏弈弋呓咦咿猗饴怡漪迤驿缢轶贻旖熠痍蜴羿胤垠喑狺氤霪龈茔萦嘤膺滢瀛瑛唷俑墉慵邕甬攸莠莜呦囿柚牖鱿黝鼬禺毓谀谕萸揄圄圉鬻妪瑜昱腴於煜聿蜮臾雩龉掾媛瑗爰眢鸢刖钺芸愠纭韫殒氲熨拶咂崽簪糌臧仄啧昃谮吒咤哳蚱嶂獐璋蟑诏棹钊谪辄磔褶蜇赭缜赈朕箴诤铮陟芷忮彘咫枳桎轾贽胝祉祗雉痣蛭絷豸冢螽踵啁妯胄籀伫侏茱渚炷铢箸翥麈啭颛僮惴骓肫倬擢涿焯镯谘孳梓辎恣眦锱龇鲻髭偬粽俎镞攥躜蕞樽怍";
function zhuan(){
	// 获取输入
	var input = document.getElementById("qinput").value.replace(/。/g,".").replace(/！/g,".");
	if(input.length==0){
		alert("请您输入一个汉字。")
		document.getElementById("qinput").value = document.getElementById("in").value.replace(/[^\u3447-\uFA29]/ig,'')
		document.getElementById("qinput").focus();
		return false;
	}

	if(/[^\u3447-\uFA29]/ig.test(input)){
		alert("请您输入汉字。【字母、数字、符号自动过滤】")
		document.getElementById("qinput").value = document.getElementById("in").value.replace(/[^\u3447-\uFA29]/ig,'')
		document.getElementById("qinput").focus();
		return false;
	}

	document.getElementById("sub2").disabled=true;
	document.getElementById("sub2").value = "正在查询中";
	var urlkey = encodeURIComponent(input).replace(/%/g,"").toLowerCase();
	if(!(font.indexOf(input)>-1)){
		urlkey = "e4b8a2";
	}

	document.getElementById("ziyuanid").innerHTML = '<img src="/zi/ziyuantu/'+urlkey+'.png" width="650px" /><br />文字强，则国强！我们鼓励您点击下面的分享图标↓分享不但是一种美德，也渗透一种源远文字文化的传承，顶起↓';

	document.getElementById("sub2").value = "查询字源";
	document.getElementById("sub2").disabled=false;



}


        //http://www.fantizi5.com/zi/ziyuantu/e781b5.png
        String str = "灵";
        try {
            Log.d(TAG, URLEncoder.encode(str, "UTF-8").replace("\u0025","").toLowerCase());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnStartService:
                Log.d(TAG, "btnStartService executed");
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
                break;
            case R.id.btnStartIntentService:
                Log.d(TAG, "btnStartIntentService executed");
                Log.d(TAG, "Thread id is " + Thread.currentThread().getId());
                Intent intentService = new Intent(MainActivity.this, MyIntentService.class);
                startService(intentService);
                break;
            case R.id.btnStartCountService:
                Log.d(TAG, "btnStartCountService executed");
                Intent intentCountService = new Intent(MainActivity.this, LongRunningService.class);
                startService(intentCountService);
                break;
        }


    }
}
