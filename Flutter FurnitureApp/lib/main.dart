import 'dart:ffi';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(

        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  TabController controller;
  int getColorHexFromStr(String colorStr) {
    colorStr = "FF" + colorStr;
    colorStr = colorStr.replaceAll("#", "");
    int val = 0;
    int len = colorStr.length;
    for (int i = 0; i < len; i++) {
      int hexDigit = colorStr.codeUnitAt(i);
      if (hexDigit >= 48 && hexDigit <= 57) {
        val += (hexDigit - 48) * (1 << (4 * (len - 1 - i)));
      } else if (hexDigit >= 65 && hexDigit <= 70) {
        // A..F
        val += (hexDigit - 55) * (1 << (4 * (len - 1 - i)));
      } else if (hexDigit >= 97 && hexDigit <= 102) {
        // a..f
        val += (hexDigit - 87) * (1 << (4 * (len - 1 - i)));
      } else {
        throw new FormatException("An error occurred when converting a color");
      }
    }
    return val;
  }
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    //controller=new TabController(length: 4, vsync: this);
  }
  @override
  void dispose() {
    // TODO: implement dispose
   // controller.dispose();//
    super.dispose();

  }
  @override
  Widget build(BuildContext context) {

    return Scaffold(

      body: ListView(
        children: [
          Column(
            children: [
              Stack(
                children: <Widget>[
                  Container(
                    height: 250,
                    width: double.infinity,
                    color: Color(getColorHexFromStr("#FDD148")),
                  ),
                  Positioned(
                    bottom: 50,
                    right: 100,
                    child: Container(
                      height: 400,
                      width: 400,
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(200),
                        color: Color(getColorHexFromStr("#FEE16D")).withOpacity(0.4)
                      ),
                    ),
                  ),
                  Positioned(
                    bottom: 100,
                    left: 150,
                    child: Container(
                      height: 300,
                      width: 300,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(200),
                          color: Color(getColorHexFromStr("#FEE16D")).withOpacity(0.4)
                      ),
                    ),
                  ),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      SizedBox(height: 15,),
                      Row(
                        children:[
                          SizedBox(width: 15,),
                          Container(
                            alignment: Alignment.topLeft,
                            height: 50,
                            width: 50,
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(25),
                              border: Border.all(
                                color: Colors.white
                              ),
                              image:DecorationImage(
                                image: AssetImage("assets/chris.jpg")
                              )
                            ),
                          ),

                          SizedBox(
                              width: MediaQuery.of(context).size.width - 120.0),
                          Container(
                            alignment: Alignment.topRight,
                            child: IconButton(
                              icon: Icon(Icons.menu),
                              iconSize: 30,
                              onPressed: (){},
                              color: Colors.white,
                            ),
                          ),
                          SizedBox(height: 15,)
                        ],
                      ),
                      SizedBox(
                        height: 50,
                      ),
                      Padding(
                          padding: const EdgeInsets.only(left: 15),
                        child: Text(
                            "Hello Aj",
                          style: TextStyle(
                            fontFamily: 'Quicksand',
                            fontSize: 30,
                            fontWeight: FontWeight.bold
                          ),
                        ),
                      ),
                      SizedBox(
                        height: 15,
                      ),
                      Padding(
                        padding: const EdgeInsets.only(left: 15),
                        child: Text(
                          "What Do you Want to Buy?",
                          style: TextStyle(
                              fontFamily: 'Quicksand',
                              fontSize: 23,
                              fontWeight: FontWeight.bold
                          ),
                        ),
                      ),
                      SizedBox(height: 30,),
                      Padding(
                        padding: EdgeInsets.only(left: 15.0, right: 15.0),
                        child: Material(
                          elevation: 5.0,
                          borderRadius: BorderRadius.circular(15.0),
                          child: TextFormField(
                              decoration: InputDecoration(
                                  border: InputBorder.none,
                                  prefixIcon: Icon(Icons.search,
                                      color:
                                      Color(getColorHexFromStr('#FEDF62')),
                                      size: 30.0),
                                  contentPadding:
                                  EdgeInsets.only(left: 15.0, top: 15.0),
                                  hintText: 'Search',
                                  hintStyle: TextStyle(
                                      color: Colors.grey,
                                      fontFamily: 'Quicksand')
                              )
                          ),
                        ),
                      )
                    ],
                  ),
                  SizedBox(height: 10,)
                ],

              ),
              SizedBox(height: 10,),
              Stack(
                children: [
                  SizedBox(height: 10,),
                  Material(
                    elevation: 1.0,
                    child: Container(
                      height: 75,
                      color: Colors.white,
                    ),
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Container(
                        height: 75,
                        width: MediaQuery.of(context).size.width/4,
                        child: Column(
                          children: [
                            Container(
                              height: 50,
                              decoration: BoxDecoration(
                                image: DecorationImage(
                                  image: AssetImage('assets/sofa.png')
                                )
                              ),
                            ),
                            Text("Sofas",style: TextStyle(
                              fontFamily: 'Quickstand'
                            ),)
                          ],
                        ),
                      ),
                      Container(
                        height: 75,
                        width: MediaQuery.of(context).size.width/4,
                        child: Column(
                          children: [
                            Container(
                              height: 50,
                              decoration: BoxDecoration(
                                  image: DecorationImage(
                                      image: AssetImage('assets/wardrobe.png')
                                  )
                              ),
                            ),
                            Text("wardrobe",style: TextStyle(
                                fontFamily: 'Quickstand'
                            ),)
                          ],
                        ),
                      ),
                      Container(
                        height: 75,
                        width: MediaQuery.of(context).size.width/4,
                        child: Column(
                          children: [
                            Container(
                              height: 50,
                              decoration: BoxDecoration(
                                  image: DecorationImage(
                                      image: AssetImage('assets/desks.png')
                                  )
                              ),
                            ),
                            Text("Desk",style: TextStyle(
                                fontFamily: 'Quickstand'
                            ),)
                          ],
                        ),
                      ),
                      Container(
                        height: 75,
                        width: MediaQuery.of(context).size.width/4,
                        child: Column(
                          children: [
                            Container(
                              height: 50,
                              decoration: BoxDecoration(
                                  image: DecorationImage(
                                      image: AssetImage('assets/dressers.png')
                                  )
                              ),
                            ),
                            Text("Dressers",style: TextStyle(
                                fontFamily: 'Quickstand'
                            ),)
                          ],
                        ),
                      ),

                    ],
                  )
                ],
              ),
              // for(int i=0;i<10;i++)
              itemCard("FinnNavin", 'assets/ottoman.jpg', false),
              itemCard("Chair", 'assets/anotherchair.jpg', true),
              itemCard("FinnNavin", 'assets/ottoman.jpg', true),
              itemCard("Chair", 'assets/anotherchair.jpg', false),
            ],
          ),

        ],
      ),
    );
  }
Widget itemCard(String title, String imgPath, bool isFavorite) {
  return Padding(
    padding: EdgeInsets.only(left: 15.0, right: 15.0, top: 15.0),
    child: Container(
      height: 150.0,
      width: double.infinity,
      color: Colors.white,
      child: Row(
        children: <Widget>[
          Container(
            width: 140.0,
            height: 150.0,
            decoration: BoxDecoration(
                image: DecorationImage(
                    image: AssetImage(imgPath), fit: BoxFit.cover)),
          ),
          SizedBox(width: 4.0),
          Column(
            children: <Widget>[
              Row(
                children: <Widget>[
                  Text(
                    title,
                    style: TextStyle(
                        fontFamily: 'Quicksand',
                        fontSize: 17.0,
                        fontWeight: FontWeight.bold),
                  ),
                  SizedBox(width: 45.0),
                  Material(
                    elevation: isFavorite ? 0.0 : 2.0,
                    borderRadius: BorderRadius.circular(20.0),
                    child: Container(
                      height: 40.0,
                      width: 40.0,
                      decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(20.0),
                          color: isFavorite
                              ? Colors.grey.withOpacity(0.2)
                              : Colors.white),
                      child: Center(
                        child: isFavorite
                            ? Icon(Icons.favorite_border)
                            : Icon(Icons.favorite, color: Colors.red),
                      ),
                    ),
                  )
                ],
              ),
              SizedBox(height: 5.0),
              Container(
                width: 175.0,
                child: Text(
                  'Scandinavian small sized double sofa imported full leather / Dale Italia oil wax leather black',
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      fontFamily: 'Quicksand',
                      color: Colors.grey,
                      fontSize: 12.0),
                ),
              ),
              SizedBox(height: 5.0),
              Row(
                children: <Widget>[
                  SizedBox(width: 35.0),
                  Container(
                    height: 40.0,
                    width: 50.0,
                    color: Color(getColorHexFromStr('#F9C335')),
                    child: Center(
                      child: Text(
                        '\$248',
                        style: TextStyle(
                            color: Colors.white,
                            fontFamily: 'Quicksand',
                            fontWeight: FontWeight.bold),
                      ),
                    ),
                  ),
                  Container(
                    height: 40.0,
                    width: 100.0,
                    color: Color(getColorHexFromStr('#FEDD59')),
                    child: Center(
                      child: Text(
                        'Add to cart',
                        style: TextStyle(
                            color: Colors.white,
                            fontFamily: 'Quicksand',
                            fontWeight: FontWeight.bold),
                      ),
                    ),
                  )
                ],
              )
            ],
          )
        ],
      ),
    ),
  );
}


}
