package com.example.test.lesson4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v7.widget.DividerItemDecoration;

/**
 * Created by fengjen on 2018/2/6.
 */

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // this is data fro recycler view
        ItemData[] itemsData = {
                new ItemData("巧克力蛋糕","可以用煎的，也可以用烤的\n煎的偏軟，烤的偏Q\n作法超簡單～零失敗"),
                new ItemData("檸檬糖霜磅蛋糕","沒有在誇張的～這完全是我吃過最好吃的磅蛋糕！微溫的時候，鬆軟得簡直一入口就化開\n蛋糕體不會太甜，配上糖霜的甜度剛剛好"),
                new ItemData("厚奶茶布丁","雖然照片看起來的賣相不好看，但是很好吃天冷熱熱的吃很暖胃"),
                new ItemData("巧克力慕斯","整份的糖跟碳水主要來自於鮮奶跟鮮奶油,各位若是嚴格生酮飲食者,後面鮮奶油不加,直接把步驟四拿來當抹醬或是拌在馬斯卡邦起司或是無糖優格上面吃再加幾顆藍莓也是相當讚的甜點 "),
                new ItemData("滋潤雪梨紅棗甜湯","天氣乾燥，最好就是吃一碗甜湯滋潤一下。雪梨紅棗糖水，滋潤養顏又美味。30分鐘就做到，煮一大鍋全家享用，秋冬必備的甜湯之選！ "),
                new ItemData("草莓果粒優格","這道甜點不只是美味，還能調整身體狀態。適合不小心吃太多時，作為調整身體狀態的甜點食用。"),
                new ItemData("麻花捲甜甜圈","甜甜圈是一種用麵粉、砂糖、奶油和雞蛋混合後經過油炸的甜食。將麵團捲成麻花狀, 炸至外酥內鬆軟, 再灑上砂糖混合肉桂, 天冷時搭配熱茶或無糖咖啡, 一起來個午茶約會吧~~"),
                new ItemData("英式麵包布丁","這個傳統英式甜點－麵包布丁Bread & Butter Pudding, 最適合冬天享用。上層是香脆的麵包，下面是綿綿的布丁，香濃美味！簡單的材料，卻能做出美味飽足的甜點！多了的麵包不要掉，做這個甜點就最好！"),
                new ItemData("瑪德琳甜甜圈","把瑪德琳蛋糕做成甜甜圈的摸樣，好吃又可愛"),
                new ItemData("芋頭西米露","泰式料理的收尾，不是來上一碗摩摩喳喳，就是想嚐個冰涼的西米露。一粒粒潔白的西谷米，藉著煮與悶的動作，化作透明Q彈的迷你珍珠，小巧一碗的份量，吸水飽和後，成了一大鍋沁涼消暑的甜湯，跟著步驟提醒，不僅食材簡易，更是經濟實惠，好吃Q彈的芋頭西米露，在家也能輕鬆做！")
        };


        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.v("[Lesson 4-4]", "[Click item] = " + id);
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
