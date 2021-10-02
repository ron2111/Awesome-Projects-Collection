import 'package:codeforces_contest/Splash.dart';
import 'package:codeforces_contest/apiservices/cfapi.dart';
import 'package:codeforces_contest/helpers/DeviceSize.dart';
import 'package:codeforces_contest/helpers/loading.dart';
import 'package:codeforces_contest/models/codeforcescontest.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:add_2_calendar/add_2_calendar.dart';
import 'package:flutter_staggered_animations/flutter_staggered_animations.dart';

void main(){
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({Key key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner:  false,
      home: SplashScreen(),
    );
  }
}
class home extends StatefulWidget {
   List<Result> upcomingContestList;
   List<Result> ongoingContestList;
   home({Key key,this.upcomingContestList,this.ongoingContestList}) : super(key: key);

  @override
  _homeState createState() => _homeState();
}
class _homeState extends State<home> {
  bool isLoading = false;
  @override
  Widget build(BuildContext context) {
    Event contestEvent (int durationInSeconds,DateTime dateTime,String title){
      return Event(
        title: title,
        description: 'Coding contest',
        location: 'Codeforces',
        endDate: dateTime.add(Duration(seconds: durationInSeconds)),
        startDate: dateTime,
      );
    }

    Widget displayUpcomingContest(int index){

      var date = DateTime.fromMillisecondsSinceEpoch(widget.upcomingContestList[index].startTimeSeconds * 1000);
      String start = DateFormat.yMMMd()
          .add_jm()
          .format(DateTime.parse(date.toString()));
      Color color = Color(0xfbf0f8ff);
      return Container(
        height: displayHeight(context)*0.1,
        decoration: BoxDecoration(
            color: color,
            borderRadius: BorderRadius.circular(10),
            boxShadow: [
              BoxShadow(color: Colors.black87,offset: Offset(-3,1),blurRadius: 2),
            ]
        ),
        child: SafeArea(
          child: Stack(
            alignment: Alignment.centerRight,
            children: [
              Positioned(
                  top: displayHeight(context)*0.02,
                  left: displayWidth(context)*0.03,
                  right: displayWidth(context)*0.35,
                  child: Text(
                   widget.upcomingContestList[index].name,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                      fontWeight: FontWeight.w500,
                      fontSize: displayWidth(context)*0.0375,
                      color: Colors.black,
                    ),
                  )),
              Positioned(
                  bottom : displayHeight(context)*0.03,
                  left: displayWidth(context)*0.03,
                  right: displayWidth(context)*0.1,
                  child: Text(
                    start,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                      fontWeight: FontWeight.w800,
                      fontSize: displayWidth(context)*0.0375,
                      color: Colors.black38,
                    ),
                  )),

              Positioned(
                right: displayWidth(context)*0.04,
                child: IconButton(
                  icon: Icon(Icons.alarm_add),
                  onPressed: (){
                    Add2Calendar.addEvent2Cal(
                      contestEvent(widget.upcomingContestList[index].durationSeconds,date, widget.upcomingContestList[index].name),
                    );
                  },
                  color: Colors.green,
                ),
              ),
            ],
          ),
        ),
      );
    }

    Widget displayOngoingContest(int index){
      var date = DateTime.fromMillisecondsSinceEpoch(widget.ongoingContestList[index].startTimeSeconds * 1000);
      String start = DateFormat.yMMMd()
          .add_jm()
          .format(DateTime.parse(date.toString()));
      Color color = Color(0xfbf0f8ff);
      return Container(
        height: displayHeight(context)*0.1,
        decoration: BoxDecoration(
            color: color,
            borderRadius: BorderRadius.circular(10),
            boxShadow: [
              BoxShadow(color: Colors.black87,offset: Offset(-3,1),blurRadius: 2),
            ]
        ),
        child: SafeArea(
          child: Stack(
            alignment: Alignment.centerRight,
            children: [
              Positioned(
                  top: displayHeight(context)*0.02,
                  left: displayWidth(context)*0.03,
                  right: displayWidth(context)*0.35,
                  child: Text(
                   widget.ongoingContestList[index].name,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                      fontWeight: FontWeight.w500,
                      fontSize: displayWidth(context)*0.0375,
                      color: Colors.black,
                    ),
                  )),
              Positioned(
                  bottom : displayHeight(context)*0.03,
                  left: displayWidth(context)*0.03,
                  right: displayWidth(context)*0.1,
                  child: Text(
                    start,
                    overflow: TextOverflow.ellipsis,
                    style: TextStyle(
                      fontWeight: FontWeight.w800,
                      fontSize: displayWidth(context)*0.0375,
                      color: Colors.black38,
                    ),
                  )),
            ],
          ),
        ),
      );
    }
    return DefaultTabController(length: 2, child: Scaffold(
      appBar: AppBar(
        centerTitle: true,
        backgroundColor: Colors.black,
        leading: Image(image: AssetImage(
          'images/cf.png',
        ),
          fit: BoxFit.fitHeight,
        ),
        title: RichText(
          text: TextSpan(
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: displayWidth(context)*0.05,
                fontFamily: 'Goldman',
              ),
              children: [
                TextSpan(text: 'CODEFORCES',style: TextStyle(
                  color: Colors.white,
                )),
                TextSpan(text: 'TIMER',style: TextStyle(
                  color: Colors.red,
                )),
              ]
          ),
        ),
        bottom: TabBar(
          tabs: [
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('Ongoing',style: TextStyle(
                  color: Colors.white,
                  fontSize: displayWidth(context)*0.042,
                ),),
                SizedBox(width: 8,),
                Icon(Icons.play_circle_fill,color: Colors.green,),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('Upcoming',style: TextStyle(
                  color: Colors.white,
                  fontSize: displayWidth(context)*0.042,
                ),),
                SizedBox(width: 8,),
                Icon(Icons.pending_actions,color: Colors.pink,),
              ],
            ),
          ],
          labelPadding: EdgeInsets.only(bottom: 13),
          indicatorColor: Colors.white,
        ),
      ),
      body: TabBarView(
        children: [
          // Ongoing contest
          Container(
            height: displayHeight(context),
            width: displayWidth(context),
            color: Colors.black,
            child: widget.ongoingContestList.length!=0?Padding(
              padding: const EdgeInsets.only(left: 15,right: 15,top: 20,bottom: 15),
              child: ListView.builder(itemBuilder: (context,index){
                return AnimationConfiguration.staggeredList(
                  position: index,
                  duration: const Duration(milliseconds: 380),
                  child: SlideAnimation(
                    verticalOffset: 50.0,
                    child:ScaleAnimation(
                      child: Padding(
                        padding: const EdgeInsets.only(bottom:15.0),
                        child: displayOngoingContest(index),
                      ),
                    ),
                  ),
                );
              },
                itemCount: widget.ongoingContestList.length,
              ),
            ):Center(
              child: Text('No ongoing contests',style: TextStyle
                (color: Colors.white,
                fontSize: displayWidth(context)*0.04
              ),),
            )
          ),

          // Upcoming contests
          Container(
            height: displayHeight(context),
            width: displayWidth(context),
            color: Colors.black,
            child: widget.upcomingContestList.length!=0?Padding(padding: EdgeInsets.only(left: 15,right: 15,top: 20,bottom: 15)
                ,child: ListView.builder(itemBuilder: (context,index){
                  return AnimationConfiguration.staggeredList(
                    position: index,
                    duration: const Duration(milliseconds: 400),
                    child: SlideAnimation(
                      verticalOffset: 50.0,
                      child: ScaleAnimation(
                        child: Padding(
                          padding: const EdgeInsets.only(bottom:15.0),
                          child: displayUpcomingContest(index),
                        ),
                      ),
                    ),
                  );
                },
                  itemCount: widget.upcomingContestList.length,
                )
            ):Center(
              child: Text('No Upcoming contests',style: TextStyle
                (color: Colors.white,
                  fontSize: displayWidth(context)*0.04
              ),),
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.red,
        child: isLoading?Loading2():Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.api,color: Colors.white,size: displayWidth(context)*0.045,),
            Text('Refresh',style: TextStyle(
                fontSize: displayWidth(context)*0.024
            ),)
          ],
        ) ,
        onPressed: ()async{
          setState(() {
            isLoading = true;
          });
          widget.upcomingContestList = await codeforcesApiServices().fetchUpcomingContestList();
          widget.ongoingContestList = await codeforcesApiServices().fetchOngoingContestList();
          //  debugPrintStack(label: 'new list caught');
          setState(() {
            isLoading = false;
          });
          ScaffoldMessenger.of(context).showSnackBar(SnackBar(content:
          Text('Contest list has been successfully updated !!'),duration: Duration(seconds: 4),));
        },
      ),
    ),
    );
  }
}
