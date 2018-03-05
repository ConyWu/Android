package com.example.test.lesson4;

/**
 * Created by fengjen on 2018/2/8.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class FifthoneActivity extends AppCompatActivity {


    private SubItemData[] subItemData = {
            new SubItemData(R.drawable.cake1,"食材\n鬆餅粉250克\n蛋黃3顆\n牛奶或水150克\n可可粉（可以不加）20克\n蛋白3顆\n糖20克\n\n作法\n1.可可粉過篩，然後食材混在一起\n2.用打蛋器打發蛋白，分次加糖，打到出現小勾勾\n3.1/3蛋白霜加入麵糊攪拌，然後在倒回蛋白霜的那盆攪拌均勻\n4.容器抹點奶油（也可以不抹）倒入麵糊把泡泡敲出來然後就可以進烤箱了～（只要拿竹籤插入看有沒有熟就OK）"),
            new SubItemData(R.drawable.cake2,"食材\n全蛋2顆\n檸檬皮屑1個份\n細砂糖85g\n檸檬汁25g\n無鹽奶油120g\n動物性鮮奶油75g\n低筋麵粉150g\n無鋁泡打粉2.5g\n小蘇打粉1g\n檸檬汁約12g\n糖粉70g\n檸檬皮屑(最後裝飾)適量\n\n作法\n1.鮮奶油和蛋退冰至室溫，趕時間可以泡在溫水中。\n2.烤模鋪上烘焙紙。\n3.麵粉、小蘇打粉和泡打粉，用打蛋器攪拌一下。\n4.無鹽奶油微波或隔水加熱至融化。\n5.檸檬皮仔細清洗乾淨後，刨出皮屑加進砂糖中。\n6.烤箱開始以175度預熱。\n7.用手指將糖和檸檬屑仔細搓揉，讓檸檬的香氛能充分釋放。\n8.加入融化還微溫的奶油拌勻\n9.加入兩顆蛋，用電動攪拌器中速攪拌至變得有點濃稠泛白，然後轉低速讓氣泡變得細緻一點。\n10.加入鮮奶油後，拌勻即可，不用過度攪拌，再加入檸檬汁拌勻。\n11.混合均勻的粉類，分兩次過篩入盆中，用刮刀以切拌的方式混合均勻。\n12.放入烤箱以175度烤20分鐘，取出用刀子在中間劃線(也可以省略)，然後以165-170度繼續烤20分，最後2-3分鐘可以調至180度讓上色更漂亮，表皮更鬆脆。\n13.檸檬糖霜的材料混合均勻，建議一次加入少量的檸檬汁慢慢調，調出舀起垂落成緞帶狀的濃稠度即可。\n14.蛋糕完全放涼後，從中央淋上糖霜，它會自己往外擴散，再灑上一些檸檬皮屑裝飾即可。"),
            new SubItemData(R.drawable.cake3,"食材\n厚奶茶（鮮奶）100-150c.c\n全蛋1顆\n\n作法\n1.把蛋加進厚奶茶裡攪拌均勻\n2.過篩\n3.進電鍋蒸囉, 水大約加了半碗至1碗左右"),
            new SubItemData(R.drawable.cake4,"食材\n全脂鮮奶250g\n蛋黃120g\n99%黑巧克力（米歇爾）260g\n赤藻醣醇40g\n動物鮮奶油280g\n\n作法\n1.鮮奶煮滾(微微冒泡就可以)\n2.蛋黃跟赤藻糖醇先混合均勻\n3.煮滾的鮮奶慢慢倒入蛋黃鍋裡(注意:蛋黃鍋裡要不停攪拌,不要把蛋黃燙熟了)\n4.將黑巧克力加入蛋黃牛奶鍋裡攪拌\n5.加入鮮奶油拌勻,這裡速度要稍微快一點,因為鮮奶油是冰的有溫差,怕巧克力會固化!\n這樣就完成了，冰冷藏是慕斯，冰冷凍是冰淇淋喔！"),
            new SubItemData(R.drawable.cake5,"食材\n雪梨3個\n紅棗8粒\n枸杞2大匙\n水800毫升\n冰糖50克\n\n作法\n將雪梨去皮去芯，再切件。紅棗去核，枸杞洗淨備用。煮沸水後，下所有材料（除了枸杞），再煮沸後轉小火煮30分鐘。\n然後下枸杞，再煮5分鐘即成！"),
            new SubItemData(R.drawable.cake6,"食材\n草莓100g\n日本甘酒(甜酒)2小匙\n優格200g\n\n作法\n草莓去蒂後用叉子壓碎。\n將日本甘酒加進壓碎後的草莓裡拌勻。最後，加進優格稍微攪拌後裝到容器中即完成。"),
            new SubItemData(R.drawable.cake7,"食材\n中筋麵粉250g\n無鹽奶油30g\n雞蛋1顆\n清水120cc\n鹽3.8g\n砂糖20g\n速發酵母3g\n\n作法\n材料放入麵包機拌勻, 完成基礎發酵\n取出分割成四等份, 滾圓, 靜置15分鐘待鬆弛 (蓋上保鮮膜 防止表面乾燥)\n將麵團搓成均勻長條, (右手朝上搓, 左手朝下搓, 粗細要一樣), 拿起麵條對折, 轉成麻花狀, 接頭捏緊 (以免散開)\n靜置發酵1小時\n鍋內倒入多一點的油, 待油溫升高, 改轉中小火, 炸至兩面金黃, 麵團熟透\n用廚房紙巾吸乾多餘油份, 待降溫後, 灑上肉桂砂糖即完成"),
            new SubItemData(R.drawable.cake8,"食材\n麵包6塊\n葡萄乾(可省略)適量\n雞蛋1個\n牛奶300毫升\n糖15克\n香草精1小匙\n紅糖或白砂糖適量\n\n作法\n用奶油塗麵包，然後切半或1/4\n用少許奶油塗抹烤盤，然後將麵包排好，再灑上葡萄乾\n將牛奶、雞蛋、香草精和糖拌勻\n將蛋液倒入烤盤內，壓一壓麵包，令每一部份都沾有蛋漿，靜置10分鐘，再在上面灑上紅糖。然後再放入已預熱180度C 烤箱，烤約30-35分鐘，在上面灑上糖霜即成！"),
            new SubItemData(R.drawable.cake9,"食材\n低筋麵粉75克\n酵母粉2克\n細砂糖55克\n雞蛋2顆\n奶油60克\n\n作法\n將奶油隔水融化至溫熱\n雞蛋加入細砂糖攪拌均勻\n篩入麵粉和酵母粉，攪拌均勻\n加入融化奶油拌勻，蓋上保鮮膜，放入冰箱冷藏50分鐘\n模具抹上奶油，從冰箱取出蛋糕糊，裝入擠花袋中，袋口剪一個小洞，擠入模具約8分滿\n放入預熱好的烤箱（先預熱200度10分鐘），180度烤20分鐘，烤至金黃色，出爐後趁熱脫模"),
            new SubItemData(R.drawable.cakea,"食材\n西谷米200g\n芋頭（300-350g)一顆\n椰漿400cc\n水500cc\n細砂糖80g\n\n作法\n將芋頭切丁蒸熟備用（電鍋外鍋2-2.5杯水）\n取西谷米約6-7倍的水量（200g西谷米用1400cc的水）待水滾佛後，倒入西谷米，煮6-8分鐘熄火。\n熄火後，上蓋悶10-12分鐘，西谷米即呈現晶瑩剔透的模樣。\n將煮熟的西谷米用冷飲用水沖洗，去掉表面的膠質、雜質，讓西谷米更Q彈透亮（可用篩網輔助），洗淨後的西谷米非常透，甚至連底部拿碗的掌心膚色皆可看見。\n接著做湯底的部分，將蒸熟芋頭取出拌糖，因為後頭不再做調味的動作，喜歡甜一點的，糖可以多拌一些。\n將椰漿倒入鍋中，拌入步驟5的蜜芋頭，煮至冒泡備用。\n將西谷米倒入芋頭椰漿，混勻後加入500cc的冷飲用水，全部攪拌均勻後，放入冰箱冷藏，即可享用。")
    };

    private ImageView im1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifthone);
        Intent intent = getIntent();
        if (intent == null) {
            Log.d("123", "null");
        } else {
            Log.d("123", "sssssss");
        }
        int intValue = intent.getIntExtra("position", 0);
        Log.d("123", Integer.toString(intValue));

        im1 = (ImageView) findViewById(R.id.imageView1);
        tv2 = (TextView) findViewById(R.id.textView4);
        im1.setImageResource(subItemData[intValue].getResource());
        tv2.setText(subItemData[intValue].getFullRecipes());
        tv2.setMovementMethod(new ScrollingMovementMethod());
    }
}