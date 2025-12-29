package com.example.project.data

object MockData {
    val recommendedAttractions = listOf(
        // --- 台北市 ---
        Attraction(1, "台北 101", "台北市信義區", "https://watermark.lovepik.com/photo/20211129/large/lovepik-taipei-101-building-picture_501181803.jpg", "台灣最具代表性的大樓。", userId = "", latitude = 25.0339, longitude = 121.5644),
        Attraction(2, "故宮博物院", "台北市士林區", "https://upload.wikimedia.org/wikipedia/commons/4/49/%E5%9C%8B%E7%AB%8B%E6%95%85%E5%AE%AE%E5%8D%9A%E7%89%A9%E9%99%A2_1001.jpg", "收藏豐富的中華文物。", userId = "", latitude = 25.1023, longitude = 121.5484),
        Attraction(3, "中正紀念堂", "台北市中正區", "https://watermark.lovepik.com/photo/20211130/large/lovepik-taiwan-zhongzheng-memorial-hall-picture_501287306.jpg", "宏偉的藍瓦白牆建築。", userId = "", latitude = 25.0346, longitude = 121.5218),
        Attraction(4, "士林夜市", "台北市士林區", "https://image.cdn-eztravel.com.tw/Dj2VZMf9_v0RjnZhPiwL5WZ1HHug-0Lxiqojr9Xo0Po/g:ce/aHR0cHM6Ly92YWNhdGlvbi5jZG4tZXp0cmF2ZWwuY29tLnR3L2ltZy9WRFIvVFAxXzc4NjQ0NjgwMy5qcGc.jpg", "著名的美食與逛街天堂。", userId = "", latitude = 25.0881, longitude = 121.5244),
        Attraction(5, "龍山寺", "台北市萬華區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRg8nX6gsjads1-Ms0CEHGVoP62s4QqeCw0Ng&s", "極具歷史意義的信仰中心。", userId = "", latitude = 25.0368, longitude = 121.4999),
        Attraction(6, "陽明山公園", "台北市北投區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDC6MB8ODRjZlqT9eC4JNWiT6Pf-fbhE0PZQ&s", "四季皆美的踏青好去處。", userId = "", latitude = 25.1558, longitude = 121.5476),
        Attraction(7, "西門町", "台北市萬華區", "https://www-ws.gov.taipei/001/Upload/308/relpic/10162/9291337/cd608a18-eb57-4e67-a1c0-93016e56da57.jpg", "流行文化的聚集地。", userId = "", latitude = 25.0422, longitude = 121.5083),

        // --- 新北市 ---
        Attraction(8, "九份老街", "新北市瑞芳區", "https://newtaipei.travel/content/images/attractions/27525/1024x768_attractions-image-fwfaxumoiegq42wwkiwkpg.jpg", "懷舊的山城美景與芋圓。", userId = "", latitude = 25.1099, longitude = 121.8452),
        Attraction(9, "淡水漁人碼頭", "新北市淡水區", "https://travelss.net/wp-content/uploads/2025/01/image-3-16.jpg", "絕美的夕陽觀賞地。", userId = "", latitude = 25.1827, longitude = 121.4116),
        Attraction(10, "野柳地質公園", "新北市萬里區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOAxaE7timg9E8Xr_B8LZRzYJuOjCGIdP6fQ&s", "聞名國際的女王頭岩石。", userId = "", latitude = 25.2065, longitude = 121.6908),
        Attraction(11, "十分瀑布", "新北市平溪區", "https://www.welcometw.com/wp-content/uploads/2020/jiufen/04/1.%E5%8D%81%E5%88%86%E7%80%91%E5%B8%83.jpg", "台灣規模最大的簾幕式瀑布。", userId = "", latitude = 25.0493, longitude = 121.7876),
        Attraction(12, "碧潭風景區", "新北市新店區", "https://newtaipei.travel/content/images/attractions/25245/1024x768_attractions-image-u5k_jfctzkcu86e9fyxkkq.jpg", "踩天鵝船放鬆的好所在。", userId = "", latitude = 24.9575, longitude = 121.5369),

        // --- 桃園/新竹 ---
        Attraction(13, "大溪老街", "桃園市大溪區", "https://travel.tycg.gov.tw/content/images/attractions/89622/1024x768_attractions-image-e8vdmixo8u2p1bapj-lz9w.jpg", "著名的豆干與巴洛克建築。", userId = "", latitude = 24.8845, longitude = 121.2871),
        Attraction(14, "小人國主題樂園", "桃園市龍潭區", "https://cdn.yiwutrip.tw/wp-content/uploads/20210301130750_a64_DSC08132_1080x720_wm.jpg", "縮小版的環遊世界體驗。", userId = "", latitude = 24.8329, longitude = 121.2001),
        Attraction(15, "六福村", "新竹縣關西鎮", "https://bewithnene.tw/wp-content/uploads/leofood.jpg", "結合野生動物園的主題樂園。", userId = "", latitude = 24.8217, longitude = 121.1824),
        Attraction(16, "南寮漁港", "新竹市北區", "https://live.staticflickr.com/65535/5875296360_b43d08121e_b.jpg", "17公里海岸線與地中海風情。", userId = "", latitude = 24.8488, longitude = 120.9161),

        // --- 台中市 ---
        Attraction(17, "台中歌劇院", "台中市西屯區", "https://www.millenniumtaichung.com.tw/upload/spot_b/2d869e3572a24b20cd885996ce8edd50.jpg", "無樑柱設計的曲牆建築。", userId = "", latitude = 24.1627, longitude = 120.6403),
        Attraction(18, "高美濕地", "台中市清水區", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/9b/d0/29/2.jpg?w=900&h=-1&s=1", "世界級的夕陽與生態保護區。", userId = "", latitude = 24.3121, longitude = 120.5501),
        Attraction(19, "彩虹眷村", "台中市南屯區", "https://www.mytaiwan.org/skin/mytaiwan/images/pictures/rainbow-village1.jpg", "繽紛色彩的塗鴉彩繪。", userId = "", latitude = 24.1337, longitude = 120.6099),
        Attraction(20, "武陵農場", "台中市和平區", "https://travel.taichung.gov.tw/image/58310/1024x768", "賞櫻與賞楓的絕佳去處。", userId = "", latitude = 24.3639, longitude = 121.3116),
        Attraction(21, "逢甲夜市", "台中市西屯區", "https://doqvf81n9htmm.cloudfront.net/data/alicelee_126/201807/0730/shutterstock_721983289.jpg", "創意小吃的發源地。", userId = "", latitude = 24.1758, longitude = 120.6456),

        // --- 南投/雲林/嘉義 ---
        Attraction(22, "日月潭", "南投縣魚池鄉", "https://lohanpush.files.wordpress.com/2020/07/1_han5298.jpg?w=1600", "湖光山色的天然美景。", userId = "", latitude = 23.8523, longitude = 120.9019),
        Attraction(23, "清境農場", "南投縣仁愛鄉", "https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1295,h_720/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/npbn9fezrelf9ywqoayx/%E5%8D%97%E6%8A%95%EF%BD%9C%E6%B8%85%E5%A2%83%E8%BE%B2%E5%A0%B4%EF%BC%86%E5%90%88%E6%AD%A1%E5%B1%B1%E4%B8%80%E6%97%A5%E9%81%8A.jpg", "可愛的綿羊與高山風光。", userId = "", latitude = 24.0581, longitude = 121.1633),
        Attraction(24, "劍湖山世界", "雲林縣古坑鄉", "https://walkinto.in/upload/-k1HhrH9HP-Jx1B3rSqBP.jpg", "刺激的遊樂設施與摩天輪。", userId = "", latitude = 23.6196, longitude = 120.5824),
        Attraction(25, "阿里山森林區", "嘉義縣阿里山鄉", "https://www.taiwan.net.tw/att/1/big_scenic_spots/pic_10949_9.jpg", "著名的日出、雲海與神木。", userId = "", latitude = 23.5111, longitude = 120.8031),
        Attraction(26, "檜意森活村", "嘉義市東區", "https://pipichocho.com/wp-content/uploads/2025/02/%E6%AA%9C%E6%84%8F%E6%A3%AE%E6%B4%BB%E6%9D%91-%E5%B0%81%E9%9D%A2%E5%9C%96.jpg", "全台最大的日式建築群。", userId = "", latitude = 23.4862, longitude = 120.4545),

        // --- 台南市 ---
        Attraction(27, "安平古堡", "台南市安平區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3w16cOAtigo2RXBwD7TdoWvBVZv9hPnSeDA&s", "台灣歷史最悠久的古堡。", userId = "", latitude = 23.0016, longitude = 120.1611),
        Attraction(28, "赤崁樓", "台南市中西區", "https://upload.wikimedia.org/wikipedia/commons/0/09/Tainan_Taiwan_Fort-Provintia-01.jpg", "充滿歷史氣息的古蹟建築。", userId = "", latitude = 22.9975, longitude = 120.2026),
        Attraction(29, "奇美博物館", "台南市仁德區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJhfsiLS6c7w9olV2PW0Eb3BQSmOd9llvC3Q&s", "歐式風格的宮殿式博物館。", userId = "", latitude = 22.9348, longitude = 120.2260),
        Attraction(30, "神農街", "台南市中西區", "https://tcmbdata.culture.tw/api/collection/image/Culture_Place?uid=273628", "充滿古意的老街文創區。", userId = "", latitude = 22.9972, longitude = 120.1969),
        Attraction(31, "台江國家公園", "台南市安南區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTST0UHC96xqHlbHjMv0ljPpp45kIcWYom8kg&s", "著名的綠色隧道紅樹林。", userId = "", latitude = 23.0485, longitude = 120.1265),

        // --- 高雄市 ---
        Attraction(32, "駁二藝術特區", "高雄市鹽埕區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyPIaSN86UXXDsO6s9_-SsbjYRKb0ERQQlLQ&s", "舊倉庫轉型的藝術聚落。", userId = "", latitude = 22.6199, longitude = 120.2815),
        Attraction(33, "旗津老街", "高雄市旗津區", "https://cc.tvbs.com.tw/img/program/upload/2024/02/06/20240206203549-578256f5.jpg", "搭渡輪、吃海鮮的經典行程。", userId = "", latitude = 22.6131, longitude = 120.2678),
        Attraction(34, "蓮池潭", "高雄市左營區", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKq3784AEsXIqtsxgEGDh2oGeWKHMPwjtVHQ&s", "著名的龍虎塔地標。", userId = "", latitude = 22.6845, longitude = 120.2974),
        Attraction(35, "佛光山", "高雄市大樹區", "https://khh.travel/image/18453/1024x768", "壯麗的佛陀紀念館。", userId = "", latitude = 22.7505, longitude = 120.4455),
        Attraction(36, "愛河風景區", "高雄市前金區", "https://www.taiwan.net.tw/att/1/big_scenic_spots/pic_625_8.jpg", "浪漫的河畔美景。", userId = "", latitude = 22.6225, longitude = 120.2894),

        // --- 屏東/宜蘭 ---
        Attraction(37, "墾丁大街", "屏東縣恆春鎮", "https://mediaim.expedia.com/destination/1/672f3eefe9a217f74cb53374bb614dd8.jpg", "國境之南的熱情與海鮮。", userId = "", latitude = 21.9452, longitude = 120.7974),
        Attraction(38, "屏東海生館", "屏東縣車城鄉", "https://smilevivi.com/wp-content/uploads/2024/02/nmmba-1.jpg", "驚艷的海底隧道。", userId = "", latitude = 22.0463, longitude = 120.6975),
        Attraction(39, "蘭陽博物館", "宜蘭縣頭城鎮", "https://www.necoast-nsa.gov.tw/FileArtPic.ashx?id=791&w=600&h=400", "獨特建築外型的在地博物館。", userId = "", latitude = 24.8617, longitude = 121.8322),
        Attraction(40, "羅東林場", "宜蘭縣羅東鎮", "https://upssmile.com/wp-content/uploads/2020/10/20200906-IMG_8363-3-1.jpg", "舒適的森林步道。", userId = "", latitude = 24.6817, longitude = 121.7725),

        // --- 花蓮/台東 ---
        Attraction(41, "太魯閣大峽谷", "花蓮縣秀林鄉", "https://www.easttaiwan.net/_api/content/images/attractions/785/1920x1080_attractions-image-s10wijqz_k68wxnjlxig5g.jpg", "大自然鬼斧神工的傑作。", userId = "", latitude = 24.1593, longitude = 121.6215),
        Attraction(42, "七星潭", "花蓮縣新城鄉", "https://travelss.net/wp-content/uploads/2025/03/image-8-314.jpg", "優美的弧形海灣與礫石。", userId = "", latitude = 24.0305, longitude = 121.6295),
        Attraction(43, "瑞穗牧場", "花蓮縣瑞穗鄉", "https://picsum.photos/id/52/200/200", "香濃鮮乳與悠閒風光。", userId = "", latitude = 23.5995, longitude = 121.3732),
        Attraction(44, "三仙台", "台東縣成功鎮", "https://www.erv-nsa.gov.tw/image/10340/1024x768", "標誌性的八拱跨海大橋。", userId = "", latitude = 23.1232, longitude = 121.4111),
        Attraction(45, "伯朗大道", "台東縣池上鄉", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Mr._Brown_Avenue.jpg/1200px-Mr._Brown_Avenue.jpg", "絕美的稻田景色。", userId = "", latitude = 23.0981, longitude = 121.2188),
        Attraction(46, "台東多良車站", "台東縣太麻里", "https://photo.settour.com.tw/900x600/https%3A%2F%2Fwww.settour.com.tw%2Fss_img%2FGDP%2F0000%2F0007%2F77%2Fori_5294700.jpg", "全台最美麗的火車站。", userId = "", latitude = 22.5074, longitude = 120.9572),

        // --- 離島與其他 ---
        Attraction(47, "澎湖雙心石滬", "澎湖縣七美鄉", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQC9lNcjrPYo2SV3TBRacYvm-AdjP1GVAPKRQ&s", "著名的傳統捕魚設施。", userId = "", latitude = 23.2163, longitude = 119.4316),
        Attraction(48, "金門翟山坑道", "金門縣金城鎮", "https://kinmen.travel/attractions/9540/1024x768_attractions-image-pz09mwf4tecqmoa2c_lsja.jpg", "震撼的軍事水域坑道。", userId = "", latitude = 24.3891, longitude = 118.3122),
        Attraction(49, "蘭嶼大天池", "台東縣蘭嶼鄉", "https://assetsv4.tripmoment.com/cdn-cgi/image/width=640,quality=75,format=auto/https://assetsv4.tripmoment.com/system/redactor_assets/pictures/19202/20d06c0f-e23e-4159-86da-60c7d70ac198.jpg", "神秘的火山湖泊。", userId = "", latitude = 22.0285, longitude = 121.5644),
        Attraction(50, "綠島燈塔", "台東縣綠島鄉", "https://www.taiwan.net.tw/att/1/big_scenic_spots/pic_A12-00379_2.jpg", "守望太平洋的白色建築。", userId = "", latitude = 22.6775, longitude = 121.4744)
    )
}