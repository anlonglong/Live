package cyou.bike.com.live.module.main.live.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:29
 * Email: anlonglong0721@gmail.com
 */

public class DetailBean extends BaseHttpOutput implements Serializable {
    private static final long serialVersionUID = 3962244008004725233L;

    /**
     * data : [{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201712/14/11/252b54c7bf3ecc8bbceef6de305cc07f_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201712/14/11/252b54c7bf3ecc8bbceef6de305cc07f_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201712/14/11/252b54c7bf3ecc8bbceef6de305cc07f_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"9182","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":13234,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"机灵鬼呆萌","online":2722,"owner_uid":"57428972","ranktype":0,"room_id":"780033","room_name":"【呆萌儿】枪刚人狠话很多的妹子","room_src":"https://rpic.douyucdn.cn/alrpic/171217/780033_1223.jpg","show_status":"1","show_time":"1513481524","specific_catalog":"","specific_status":"0","subject":"","url":"/780033","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/780033_1223.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201610/05/07/14a2437d30be98480a9a217c47cced8f_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201610/05/07/14a2437d30be98480a9a217c47cced8f_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201610/05/07/14a2437d30be98480a9a217c47cced8f_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"1120658","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":279863,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"sy是个萌妹","online":219008,"owner_uid":"1533834","ranktype":0,"room_id":"423895","room_name":"【iGLolix】绝地狙皇，发烧了练枪","room_src":"https://rpic.douyucdn.cn/alrpic/171217/423895_1221.jpg","show_status":"1","show_time":"1513469169","specific_catalog":"lolix","specific_status":"1","subject":"","url":"/lolix","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/423895_1221.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201712/12/21/8bff4a26f14187da52507c2d9bf29627_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201712/12/21/8bff4a26f14187da52507c2d9bf29627_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201712/12/21/8bff4a26f14187da52507c2d9bf29627_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"99167","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":21756,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"nico怎么又生气了","online":6601,"owner_uid":"6445274","ranktype":0,"room_id":"219741","room_name":"nico周末厨房：吃袋鼠！","room_src":"https://rpic.douyucdn.cn/alrpic/171217/219741_1220.jpg","show_status":"1","show_time":"1513480895","specific_catalog":"","specific_status":"0","subject":"","url":"/219741","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/219741_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201709/24/16/5e905c804a9a5941a504a89e3890d76b_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201709/24/16/5e905c804a9a5941a504a89e3890d76b_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201709/24/16/5e905c804a9a5941a504a89e3890d76b_small.jpg?rltime","cate_id":270,"child_id":517,"fans":"3006039","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":6342117,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"丶蛇哥colin","online":1880715,"owner_uid":"3427950","ranktype":0,"room_id":"85981","room_name":"蛇哥!死一次500!吃鸡500!","room_src":"https://rpic.douyucdn.cn/alrpic/171217/85981_1220.jpg","show_status":"1","show_time":"1513476572","specific_catalog":"colin","specific_status":"1","subject":"","url":"/colin","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/85981_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/face/201608/31/7717fb9606c2df4ffd1f4690e454fd20_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201608/31/7717fb9606c2df4ffd1f4690e454fd20_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201608/31/7717fb9606c2df4ffd1f4690e454fd20_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"2109218","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":581050,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"妃凌雪","online":340249,"owner_uid":"1670103","ranktype":0,"room_id":"78561","room_name":"雪MM：不开挂不代打的妹子","room_src":"https://rpic.douyucdn.cn/alrpic/171217/78561_1220.jpg","show_status":"1","show_time":"1513481999","specific_catalog":"flxow","specific_status":"0","subject":"","url":"/78561","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/78561_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/face/201604/22f41ab16cc1074c941e55f71c2a5a18_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201604/22f41ab16cc1074c941e55f71c2a5a18_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201604/22f41ab16cc1074c941e55f71c2a5a18_small.jpg?rltime","cate_id":270,"child_id":517,"fans":"596","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":166,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"牛二盒","online":65,"owner_uid":"14419874","ranktype":0,"room_id":"3340941","room_name":"早起的快递员有鸡吃！！！随缘抽奖！！！","room_src":"https://rpic.douyucdn.cn/alrpic/171217/3340941_1231.jpg","show_status":"1","show_time":"1513467553","specific_catalog":"","specific_status":"0","subject":"","url":"/3340941","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/3340941_1231.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/001/00/17/26_avatar_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/001/00/17/26_avatar_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/001/00/17/26_avatar_small.jpg?rltime","cate_id":270,"child_id":517,"fans":"4339723","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":519667,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"主播油条","online":237891,"owner_uid":"1001726","ranktype":0,"room_id":"56040","room_name":"条: 论如何高效潜入决战圈之单人四排！","room_src":"https://rpic.douyucdn.cn/alrpic/171217/56040_1220.jpg","show_status":"1","show_time":"1513472736","specific_catalog":"","specific_status":"0","subject":"","url":"/56040","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/56040_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201706/29/09/ec1c14675162ea03a5c199cac23fd95d_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201706/29/09/ec1c14675162ea03a5c199cac23fd95d_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201706/29/09/ec1c14675162ea03a5c199cac23fd95d_small.jpg?rltime","cate_id":270,"child_id":517,"fans":"1142031","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":386383,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"17shou丷","online":272737,"owner_uid":"16302988","ranktype":0,"room_id":"2267291","room_name":"一点半抽1080Ti电脑主机","room_src":"https://rpic.douyucdn.cn/alrpic/171217/2267291_1228.jpg","show_status":"1","show_time":"1513476449","specific_catalog":"","specific_status":"0","subject":"","url":"/2267291","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/2267291_1228.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201701/07/03/26ee6e114116038124b7c123617c6daa_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201701/07/03/26ee6e114116038124b7c123617c6daa_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201701/07/03/26ee6e114116038124b7c123617c6daa_small.jpg?rltime","cate_id":270,"child_id":517,"fans":"668549","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":167856,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"yjjimpaopao","online":45843,"owner_uid":"4226791","ranktype":0,"room_id":"687423","room_name":"YJJ   有点飘头疼","room_src":"https://rpic.douyucdn.cn/alrpic/171217/687423_1223.jpg","show_status":"1","show_time":"1513482609","specific_catalog":"YJJPAOPAO","specific_status":"0","subject":"","url":"/687423","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/687423_1223.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/001/97/44/29_avatar_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/001/97/44/29_avatar_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/001/97/44/29_avatar_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"1753347","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":126950,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"刘飞儿faye","online":13850,"owner_uid":"1974429","ranktype":0,"room_id":"265438","room_name":"刘飞儿 拍写真","room_src":"https://rpic.douyucdn.cn/alrpic/171217/265438_1101.jpg","show_status":"1","show_time":"1513484610","specific_catalog":"liufeier","specific_status":"1","subject":"","url":"/liufeier","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/265438_1101.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/face/201609/13/55b1879c71c43b90c6aa7bca5d68d4d6_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201609/13/55b1879c71c43b90c6aa7bca5d68d4d6_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201609/13/55b1879c71c43b90c6aa7bca5d68d4d6_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"20578","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":97750,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"灼热记忆的碎片","online":14182,"owner_uid":"89529","ranktype":0,"room_id":"3044","room_name":"跳一哈伞 。","room_src":"https://rpic.douyucdn.cn/alrpic/171217/3044_1220.jpg","show_status":"1","show_time":"1513479229","specific_catalog":"","specific_status":"0","subject":"","url":"/3044","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/3044_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201711/30/00/372328549ff56450c72b58bda5eae900_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201711/30/00/372328549ff56450c72b58bda5eae900_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201711/30/00/372328549ff56450c72b58bda5eae900_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"308605","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":88160,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"47号Gamer","online":10809,"owner_uid":"11412528","ranktype":0,"room_id":"2461752","room_name":"18:30抽1080ti万元主机一台！","room_src":"https://rpic.douyucdn.cn/alrpic/171217/2461752_1229.jpg","show_status":"1","show_time":"1513483889","specific_catalog":"","specific_status":"0","subject":"","url":"/2461752","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/2461752_1229.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/003/50/21/02_avatar_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/003/50/21/02_avatar_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/003/50/21/02_avatar_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"714736","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":78929,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"高冷丑男暖心囧","online":43861,"owner_uid":"3502102","ranktype":0,"room_id":"83379","room_name":"更新后的测试服好清楚！爽！","room_src":"https://rpic.douyucdn.cn/alrpic/171217/83379_1220.jpg","show_status":"1","show_time":"1513479449","specific_catalog":"lvyou","specific_status":"1","subject":"","url":"/lvyou","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/83379_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/face/201604/30/4fd9e74b3378872198e838f1a47118e9_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201604/30/4fd9e74b3378872198e838f1a47118e9_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201604/30/4fd9e74b3378872198e838f1a47118e9_small.jpg?rltime","cate_id":270,"child_id":517,"fans":"75876","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":78854,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"Tensi","online":26180,"owner_uid":"1040169","ranktype":0,"room_id":"620023","room_name":"TD：科技一般的压枪怪","room_src":"https://rpic.douyucdn.cn/alrpic/171217/620023_1222.jpg","show_status":"1","show_time":"1513477741","specific_catalog":"","specific_status":"0","subject":"","url":"/620023","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/620023_1222.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201711/06/15/0295870b7fe9efae16d3e76376b02662_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201711/06/15/0295870b7fe9efae16d3e76376b02662_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201711/06/15/0295870b7fe9efae16d3e76376b02662_small.jpg?rltime","cate_id":270,"child_id":518,"fans":"532131","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":77925,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"黄金大奖赛","online":6633,"owner_uid":"18396607","ranktype":0,"room_id":"276685","room_name":"【决赛】黄金大奖赛第2季4排DAY2","room_src":"https://rpic.douyucdn.cn/alrpic/171217/276685_1221.jpg","show_status":"1","show_time":"1513343168","specific_catalog":"","specific_status":"0","subject":"","url":"/276685","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/276685_1221.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201711/07/07/8e5d813cd4c7657eae2af83b27fa1478_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201711/07/07/8e5d813cd4c7657eae2af83b27fa1478_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201711/07/07/8e5d813cd4c7657eae2af83b27fa1478_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"158940","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":75140,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"李雨潼","online":37987,"owner_uid":"4293465","ranktype":0,"room_id":"222836","room_name":"今天是美少女狙神：）","room_src":"https://rpic.douyucdn.cn/alrpic/171217/222836_1220.jpg","show_status":"1","show_time":"1513443871","specific_catalog":"liyutong","specific_status":"1","subject":"","url":"/liyutong","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/222836_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201708/14/22/471743d21f4a8243ce6cc678576db830_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201708/14/22/471743d21f4a8243ce6cc678576db830_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201708/14/22/471743d21f4a8243ce6cc678576db830_small.jpg?rltime","cate_id":270,"child_id":518,"fans":"312309","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":71507,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"摩卡加冰丶","online":48724,"owner_uid":"13309476","ranktype":0,"room_id":"227764","room_name":"【摩卡】精准的投掷手..","room_src":"https://rpic.douyucdn.cn/alrpic/171217/227764_1220.jpg","show_status":"1","show_time":"1513466309","specific_catalog":"doubimoca","specific_status":"0","subject":"","url":"/227764","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/227764_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avatar/face/201603/907e80665f7e2b6a223655912e583c26_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/face/201603/907e80665f7e2b6a223655912e583c26_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201603/907e80665f7e2b6a223655912e583c26_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"269683","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":59575,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"午夜抹抹茶","online":39088,"owner_uid":"3191316","ranktype":0,"room_id":"80432","room_name":"斗鱼第一逼逼机-复盘鬼才的带妹逗比之旅","room_src":"https://rpic.douyucdn.cn/alrpic/171217/80432_1220.jpg","show_status":"1","show_time":"1513477960","specific_catalog":"whysodiao","specific_status":"1","subject":"","url":"/whysodiao","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/80432_1220.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201712/08/15/a6c7a97b115137a579aca41b774ab447_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201712/08/15/a6c7a97b115137a579aca41b774ab447_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201712/08/15/a6c7a97b115137a579aca41b774ab447_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"33404","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":53642,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"希噢鸡王","online":4382,"owner_uid":"157755938","ranktype":0,"room_id":"2926817","room_name":"宝贝儿！你赢啦！~ 轻声说：我爱你","room_src":"https://rpic.douyucdn.cn/alrpic/171217/2926817_1230.jpg","show_status":"1","show_time":"1513443803","specific_catalog":"xioo8","specific_status":"1","subject":"","url":"/xioo8","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/2926817_1230.jpg","vod_quality":"0"},{"anchor_city":"","avatar":"https://apic.douyucdn.cn/upload/avanew/face/201703/25/18/630a2c6e192aad731c34270303ddbf1c_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201703/25/18/630a2c6e192aad731c34270303ddbf1c_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201703/25/18/630a2c6e192aad731c34270303ddbf1c_small.jpg?rltime","cate_id":270,"child_id":516,"fans":"199993","game_name":"绝地求生","game_url":"/directory/game/jdqs","hn":47921,"isVertical":0,"is_noble_rec":0,"jumpUrl":"","nickname":"甜心战士","online":8287,"owner_uid":"12378197","ranktype":0,"room_id":"242045","room_name":"❤我要成为一个高手❤","room_src":"https://rpic.douyucdn.cn/alrpic/171217/242045_1221.jpg","show_status":"1","show_time":"1513474835","specific_catalog":"cutiehoney","specific_status":"1","subject":"","url":"/cutiehoney","vertical_src":"https://rpic.douyucdn.cn/alrpic/171217/242045_1221.jpg","vod_quality":"0"}]
     * error : 0
     */

    private int error;
    private List<DataBean> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * anchor_city :
         * avatar : https://apic.douyucdn.cn/upload/avanew/face/201712/14/11/252b54c7bf3ecc8bbceef6de305cc07f_big.jpg?rltime
         * avatar_mid : https://apic.douyucdn.cn/upload/avanew/face/201712/14/11/252b54c7bf3ecc8bbceef6de305cc07f_middle.jpg?rltime
         * avatar_small : https://apic.douyucdn.cn/upload/avanew/face/201712/14/11/252b54c7bf3ecc8bbceef6de305cc07f_small.jpg?rltime
         * cate_id : 270
         * child_id : 516
         * fans : 9182
         * game_name : 绝地求生
         * game_url : /directory/game/jdqs
         * hn : 13234
         * isVertical : 0
         * is_noble_rec : 0
         * jumpUrl :
         * nickname : 机灵鬼呆萌
         * online : 2722
         * owner_uid : 57428972
         * ranktype : 0
         * room_id : 780033
         * room_name : 【呆萌儿】枪刚人狠话很多的妹子
         * room_src : https://rpic.douyucdn.cn/alrpic/171217/780033_1223.jpg
         * show_status : 1
         * show_time : 1513481524
         * specific_catalog :
         * specific_status : 0
         * subject :
         * url : /780033
         * vertical_src : https://rpic.douyucdn.cn/alrpic/171217/780033_1223.jpg
         * vod_quality : 0
         */

        private String anchor_city;
        private String avatar;
        private String avatar_mid;
        private String avatar_small;
        private int cate_id;
        private int child_id;
        private String fans;
        private String game_name;
        private String game_url;
        private int hn;
        private int isVertical;
        private int is_noble_rec;
        private String jumpUrl;
        private String nickname;
        private int online;
        private String owner_uid;
        private int ranktype;
        private String room_id;
        private String room_name;
        private String room_src;
        private String show_status;
        private String show_time;
        private String specific_catalog;
        private String specific_status;
        private String subject;
        private String url;
        private String vertical_src;
        private String vod_quality;

        public String getAnchor_city() {
            return anchor_city;
        }

        public void setAnchor_city(String anchor_city) {
            this.anchor_city = anchor_city;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatar_mid() {
            return avatar_mid;
        }

        public void setAvatar_mid(String avatar_mid) {
            this.avatar_mid = avatar_mid;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public int getCate_id() {
            return cate_id;
        }

        public void setCate_id(int cate_id) {
            this.cate_id = cate_id;
        }

        public int getChild_id() {
            return child_id;
        }

        public void setChild_id(int child_id) {
            this.child_id = child_id;
        }

        public String getFans() {
            return fans;
        }

        public void setFans(String fans) {
            this.fans = fans;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getGame_url() {
            return game_url;
        }

        public void setGame_url(String game_url) {
            this.game_url = game_url;
        }

        public int getHn() {
            return hn;
        }

        public void setHn(int hn) {
            this.hn = hn;
        }

        public int getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(int isVertical) {
            this.isVertical = isVertical;
        }

        public int getIs_noble_rec() {
            return is_noble_rec;
        }

        public void setIs_noble_rec(int is_noble_rec) {
            this.is_noble_rec = is_noble_rec;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getOwner_uid() {
            return owner_uid;
        }

        public void setOwner_uid(String owner_uid) {
            this.owner_uid = owner_uid;
        }

        public int getRanktype() {
            return ranktype;
        }

        public void setRanktype(int ranktype) {
            this.ranktype = ranktype;
        }

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_src() {
            return room_src;
        }

        public void setRoom_src(String room_src) {
            this.room_src = room_src;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }

        public String getSpecific_catalog() {
            return specific_catalog;
        }

        public void setSpecific_catalog(String specific_catalog) {
            this.specific_catalog = specific_catalog;
        }

        public String getSpecific_status() {
            return specific_status;
        }

        public void setSpecific_status(String specific_status) {
            this.specific_status = specific_status;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVertical_src() {
            return vertical_src;
        }

        public void setVertical_src(String vertical_src) {
            this.vertical_src = vertical_src;
        }

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }
    }
}
