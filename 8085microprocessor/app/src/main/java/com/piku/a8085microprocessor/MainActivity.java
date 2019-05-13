package com.piku.a8085microprocessor;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.piku.a8085microprocessor.Groups.GroupA;
import com.piku.a8085microprocessor.Groups.GroupB;
import com.piku.a8085microprocessor.Groups.GroupC;
import com.piku.a8085microprocessor.Groups.GroupD;
import com.piku.a8085microprocessor.Groups.GroupE;
import com.piku.a8085microprocessor.Groups.GroupF;
import com.piku.a8085microprocessor.Groups.GroupG;
import com.piku.a8085microprocessor.Groups.GroupH;
import com.piku.a8085microprocessor.Groups.GroupI;
import com.piku.a8085microprocessor.Groups.GroupJ;
import com.piku.a8085microprocessor.Groups.GroupK;
import com.piku.a8085microprocessor.Groups.GroupL;
import com.piku.a8085microprocessor.Groups.GroupM;
import com.piku.a8085microprocessor.Groups.GroupN;
import com.piku.a8085microprocessor.Groups.GroupO;
import com.piku.a8085microprocessor.Groups.GroupP;
import com.piku.a8085microprocessor.Groups.GroupQ;
import com.piku.a8085microprocessor.Groups.GroupR;
import com.piku.a8085microprocessor.Groups.GroupS;
import com.piku.a8085microprocessor.Groups.GroupT;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int layout = R.layout.adapter_view_layout;

        Log.d(TAG, "onCreate: Started ");
        final ListView mListView = findViewById(R.id.listView);

        //Create Groups object
        DataModel A = new DataModel("1.MVI Rd,data8"+"\n2.ADI data8"+"\n3.ACI data8"+"\n4.SUI data8"+"\n5.SBI data8"+
                                    "\n6.CPI data8"+"\n7.ANI data8"+"\n8.ORI data8"+"\n9.XRI data8");
        DataModel B = new DataModel("1.MOV Rd,M"+"\n2.LDAX RP"+"\n3.ADD M"+"\n4.ADC M"+"\n5.SUB M"+
                                    "\n6.SBB M"+"\n7.CMP M"+"\n8.ANA M"+"\n9.ORA M"+"\n10.XRA M");
        DataModel C = new DataModel("1.MOV M,Rs"+"\n2.STAX RP");
        DataModel D = new DataModel("LHLD Addr16");
        DataModel E = new DataModel("LDA Addr16");
        DataModel F = new DataModel("1.MOV Rd,Rs"+"\n2.XCHG"+"\n3.ADD R"+"\n4.ACD R"+"\n5.SUB R"+"\n6.SUBB R"+"\n7.CMP R"+
                                    "\n8.INR R"+"\n9.DCR R"+"\n10.DAA"+"\n11.ANA R"+"\n12.ORA R"+"\n13.XRA R"+"\n14.CMA"+"\n15.CMC"+
                                    "\n16.STC"+"\n17.RLC"+"\n18.RAL"+"\n19.RRC"+"\n20.RAR"+"\n21.NOP"+"\n22.EI"+"\n23.DI"+
                                    "\n24.SIM"+"\n25.RIM");
        DataModel G = new DataModel("1.LXI Rp,Addr16"+"\n2.JMP Addr16"+"\n3.Jcondition Addr16");
        DataModel H = new DataModel("SHLD Addr16");
        DataModel I = new DataModel("STA Addr16");
        DataModel J = new DataModel("XTHL");
        DataModel K = new DataModel("1.POP Rp"+"\n2.RET");
        DataModel L = new DataModel("1.INR M"+"\n2.DCR M");
        DataModel M = new DataModel("OUT data8");
        DataModel N = new DataModel("PUSH Rp");
        DataModel O = new DataModel("CALL Addr16");
        DataModel P = new DataModel("1.INX Rp"+"\n2.DCX Rp"+"\n3.SPHL"+"\n4.PCHL");
        DataModel Q = new DataModel("Rcondition");
        DataModel R = new DataModel("Rstn");
        DataModel S = new DataModel("DAD Rp");
        DataModel T = new DataModel("HLT");

        //Add the group object to an ArrayList
        final ArrayList<DataModel> DataModelList = new ArrayList<>();
        DataModelList.add(A);
        DataModelList.add(B);
        DataModelList.add(C);
        DataModelList.add(D);
        DataModelList.add(E);
        DataModelList.add(F);
        DataModelList.add(G);
        DataModelList.add(H);
        DataModelList.add(I);
        DataModelList.add(J);
        DataModelList.add(K);
        DataModelList.add(L);
        DataModelList.add(M);
        DataModelList.add(N);
        DataModelList.add(O);
        DataModelList.add(P);
        DataModelList.add(Q);
        DataModelList.add(R);
        DataModelList.add(S);
        DataModelList.add(T);

        DataModelListAdapter adapter = new DataModelListAdapter(this, layout , DataModelList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.d(TAG, "onItemClick: "+ DataModelList.get(position).getName());

                if (DataModelList.get(position).getName().equalsIgnoreCase("1.MVI Rd,data8"+"\n2.ADI data8"+"\n3.ACI data8"+"\n4.SUI data8"+"\n5.SBI data8"+
                        "\n6.CPI data8"+"\n7.ANI data8"+"\n8.ORI data8"+"\n9.XRI data8"))
                    startActivity(new Intent(MainActivity.this,GroupA.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.MOV Rd,M"+"\n2.LDAX RP"+"\n3.ADD M"+"\n4.ADC M"+"\n5.SUB M"+
                        "\n6.SBB M"+"\n7.CMP M"+"\n8.ANA M"+"\n9.ORA M"+"\n10.XRA M"))
                    startActivity(new Intent(MainActivity.this,GroupB.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.MOV M,Rs"+"\n2.STAX RP"))
                    startActivity(new Intent(MainActivity.this,GroupC.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("LHLD Addr16"))
                    startActivity(new Intent(MainActivity.this,GroupD.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("LDA Addr16"))
                    startActivity(new Intent(MainActivity.this,GroupE.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.MOV Rd,Rs"+"\n2.XCHG"+"\n3.ADD R"+"\n4.ACD R"+ "\n5.SUB R"+
                        "\n6.SUBB R"+"\n7.CMP R"+ "\n8.INR R"+"\n9.DCR R"+"\n10.DAA"+"\n11.ANA R"+"\n12.ORA R"+"\n13.XRA R"+"\n14.CMA"+"\n15.CMC"+
                        "\n16.STC"+"\n17.RLC"+"\n18.RAL"+"\n19.RRC"+"\n20.RAR"+"\n21.NOP"+"\n22.EI"+"\n23.DI"+ "\n24.SIM"+"\n25.RIM"))
                    startActivity(new Intent(MainActivity.this,GroupF.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.LXI Rp,Addr16"+"\n2.JMP Addr16"+"\n3.Jcondition Addr16"))
                    startActivity(new Intent(MainActivity.this,GroupG.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("SHLD Addr16"))
                    startActivity(new Intent(MainActivity.this,GroupH.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("STA Addr16"))
                    startActivity(new Intent(MainActivity.this,GroupI.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("XTHL"))
                    startActivity(new Intent(MainActivity.this,GroupJ.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.POP Rp"+"\n2.RET"))
                    startActivity(new Intent(MainActivity.this,GroupK.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.INR M"+"\n2.DCR M"))
                    startActivity(new Intent(MainActivity.this,GroupL.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("OUT data8"))
                    startActivity(new Intent(MainActivity.this,GroupM.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("PUSH Rp"))
                    startActivity(new Intent(MainActivity.this,GroupN.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("CALL Addr16"))
                    startActivity(new Intent(MainActivity.this,GroupO.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("1.INX Rp"+"\n2.DCX Rp"+"\n3.SPHL"+"\n4.PCHL"))
                    startActivity(new Intent(MainActivity.this,GroupP.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("Rcondition"))
                    startActivity(new Intent(MainActivity.this,GroupQ.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("Rstn"))
                    startActivity(new Intent(MainActivity.this,GroupR.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("DAD Rp"))
                    startActivity(new Intent(MainActivity.this,GroupS.class));

                else if (DataModelList.get(position).getName().equalsIgnoreCase("HLT"))
                    startActivity(new Intent(MainActivity.this,GroupT.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       super.onCreateOptionsMenu(menu);

       getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.about)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(false)
                    .setTitle("About")
                    .setMessage("8085 Microprocessor Timing Diagrams ." +
                            "\nApp Made By Pranav kumar .")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            builder.show();
        }

        return true;
    }
}
