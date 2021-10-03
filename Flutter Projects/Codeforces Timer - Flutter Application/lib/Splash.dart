import 'package:codeforces_contest/apiservices/cfapi.dart';
import 'package:codeforces_contest/helpers/loading.dart';
import 'package:codeforces_contest/main.dart';
import 'package:codeforces_contest/models/codeforcescontest.dart';
import 'package:flutter/material.dart';
import 'dart:async';
import 'helpers/DeviceSize.dart';

class SplashScreen extends StatefulWidget {
  @override
  _SplashScreenState createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  List<Result> ongoing=[];
  List<Result> upcoming=[];
  void initState() {
    super.initState();
    _mockCheckForSession().then((status) {
      _navigateToHome();
    });
  }

  Future<bool> _mockCheckForSession() async {
    ongoing =  await codeforcesApiServices().fetchOngoingContestList();
    upcoming = await codeforcesApiServices().fetchUpcomingContestList();
    return true;
  }

  void _navigateToHome() {
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (BuildContext context) => home(ongoingContestList: ongoing,upcomingContestList: upcoming,)));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors. black,
        constraints: BoxConstraints.expand(),
        height: displayHeight(context),
        width: displayWidth(context),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              RichText(
                text: TextSpan(
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: displayWidth(context)*0.065,
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
              SizedBox(height: 20,),
              Loading(),
            ],
          ),
        ),
      ),
    );
  }
}
