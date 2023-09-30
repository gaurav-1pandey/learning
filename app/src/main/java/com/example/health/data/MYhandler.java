package com.example.health.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import com.example.health.params.params;

import java.util.ArrayList;
import java.util.HashMap;


public class MYhandler extends SQLiteOpenHelper {
    public MYhandler(Context context ) {
        super(context, params.DB_NAME,null,params.DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase mydb) {
        String q1 ="create table users(username text,email text,password text)";
        mydb.execSQL(q1);

        String q2 = "create table cart(username text,product text,price text,ordertype text)";
        mydb.execSQL(q2);



//        String createDocData=" create table data(name text,address text, exp text,mob text,fees text,doctype text)";
//
//        mydb.execSQL(createDocData);


//        String[][] a= {{"name : gaurav pandey","address : Nirala Nagar","experience : 2 years","Mobile : 9919111798","Fees : 600"},
//                {"name : Maya pandey","address : Nirala nagar","experience : 30 Years","Mobile : 9792314331","Fees : 5000"},
//                {"name : Gauri pandey","address : New Chwok","experience : 5 years","Mobile : 7518754106","Fees : 1000"},
//                {"name : Ankit Yadav","address : Jeera Basti","experience : 3 Years","Mobile : 7355773390","Fees : 700"},
//                {"name : Rajnish Sah","address : Champaran","experience : 17 years","Mobile : 7632687264","Fees : 1200"}};


//        SQLiteDatabase dk = this.getWritableDatabase();
//        for (String[] s : a){
//            ContentValues ck = new ContentValues();
//            ck.put("name",s[0]);
//            ck.put("address",s[1]);
//            ck.put("exp",s[2]);
//            ck.put("mob",s[3]);
//            ck.put("fees",s[4]);
//            ck.put("doctype","Physician");
//            dk.insert("data",null,ck);
//        }
//        dk.close();




//
//        String i1= "insert into "+ params.DATA_TABLENAME+ " ( "+ params.D_KEY_NAME +","+params.D_KEY_ADDRESS
//                + " , " +params.D_KEY_EXPE+ " , " +params.D_KEY_MOB_NO +
//                ", " +params.D_KEY_FEES+","+params.D_KEY_DOCTYPE+ ") "+" values(" + "\"Doctor Name : gaurav pandey\","+
//                "\"Address : Nirala Nagar\","+ "\"Experience : 10 years\","+"\"Contact : 9919111798\","+"\"Fees : 600 \","+"Physician )";
//
//
//        String i2="insert into "+ params.DATA_TABLENAME+ " ( "+ params.D_KEY_NAME +","+params.D_KEY_ADDRESS
//                + " , " +params.D_KEY_EXPE+ " , " +params.D_KEY_MOB_NO +
//                ", " +params.D_KEY_FEES+","+params.D_KEY_DOCTYPE+ ") "+" values(" + "\"Doctor Name : Maya Pandey\","+
//                "\"Address : Nirala Nagar\","+ "\"Experience : 30 years\","+"\"Contact : 9792314331\","+"\"Fees : Free* \","+"Physician)";
//
//
//        String i3="insert into "+ params.DATA_TABLENAME+ " ( "+ params.D_KEY_NAME +","+params.D_KEY_ADDRESS
//                + " , " +params.D_KEY_EXPE+ " , " +params.D_KEY_MOB_NO +
//                ", " +params.D_KEY_FEES+","+params.D_KEY_DOCTYPE+ ") "+" values(" + "\"Doctor Name : Gauri\","+
//                "\"Address : New Chwok\","+ "\"Experience : 15 years\","+"\"Contact : 7518754106\","+"\"Fees : 500 \","+"Physician)";
//
//
//        String i4="insert into "+ params.DATA_TABLENAME+ " ( "+ params.D_KEY_NAME +","+params.D_KEY_ADDRESS
//                + " , " +params.D_KEY_EXPE+ " , " +params.D_KEY_MOB_NO +
//                ", " +params.D_KEY_FEES+","+params.D_KEY_DOCTYPE+ ") "+" values(" + "\"Doctor Name : Ankit Yadav\","+
//                "\"Address : Jeera Basti\","+ "\"Experience : 15 years\","+"\"Contact : 7355773390\","+"\"Fees : 900 \","+"Physician)";
//
//
//        String i5="insert into "+ params.DATA_TABLENAME+ " ( "+ params.D_KEY_NAME +","+params.D_KEY_ADDRESS
//                + " , " +params.D_KEY_EXPE+ " , " +params.D_KEY_MOB_NO +
//                ", " +params.D_KEY_FEES+","+params.D_KEY_DOCTYPE+ ") "+" values(" + "\"Doctor Name : Mamta Pandey\","+
//                "\"Address : Hongkong\","+ "\"Experience : 20 years\","+"\"Contact : 6357898235\","+"\"Fees : 2500 \","+"Physician)";
//        String i1= "insert into data(name,address,exp,mob,fees) values(gaurav,niralaNagar,fiveyears,9919111798,sexHundred)";
//        Log.d("kuch nahi","hogya");
//        System.out.println("kuchnahi");
//        mydb.execSQL(i1);
////        mydb.execSQL(i2);
////        mydb.execSQL(i3);
////        mydb.execSQL(i4);
////        mydb.execSQL(i5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

//    public void addContact(contuple contact){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues c= new ContentValues();
//        c.put(params.KEY_ID,contact.getId());
//        c.put(params.KEY_NAME,contact.getName());
//        c.put(params.KEY_PHONE,contact.getNmbr());
//        db.insert(params.TABLE_NAME,null,c);
//        db.close();
//    }




    public void register (String username,String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("users",null,cv);
        db.close();}



    public int login(String username,String password){
        int result=0;
        String a[] = new String[2];
        a[0]=username;
        a[1]=password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",a);
        if (c.moveToFirst()){
            result=1;
        }
        c.close();
        return result;
    }


    public void deletefrmcart(String username,String product){
        String a[]=new String[2];
        a[0]=username;
        a[1]=product;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=? and product=?",a);
        db.close();


    }




    public int checkcart(String username,String product){
        int res=0;
        String a[]=new String[2];
        a[0]=username;
        a[1]=product;
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from cart where username=? and product=?",a);
        if (c.moveToFirst()){
            res=1;
        }
        c.close();
        db.close();
        return res;
    }
    public void addtocart(String username,String product,String price,String ordertype){

        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("ordertype",ordertype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart",null,cv);
        db.close();
    }

    public ArrayList getcartdetail(String username){
        HashMap h;
        ArrayList cartlist=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] selectionarg={username};
        String q ="select * from cart where username=?";
        Cursor c=db.rawQuery(q,selectionarg);
        if (c.moveToFirst()){
            do{
                h=new HashMap();
                h.put("name",c.getString(0));
                h.put("product",c.getString(1));
                h.put("price",c.getString(2));
                h.put("type",c.getString(3));
                cartlist.add(h);
            }while (c.moveToNext());
        }c.close();
        return cartlist;
    }

//
//
//    public String[][] getalldata(){
//
//        String[][] a=new String[5][5];
//        SQLiteDatabase db = getReadableDatabase();
//
//        String f= "select * from data";
//        Cursor c = db.rawQuery(f,null);
//        int i=0;
//        if (c.moveToFirst()){
//            do{
//                a[i][0]=c.getString(0);
//                a[i][1]=c.getString(1);
//                a[i][2]=c.getString(2);
//                a[i][3]=c.getString(3);
//                a[i][4]=c.getString(4);
//                i++;
//            }while(c.moveToNext());
//        }
//        db.close();
//        return a;
//    }


}