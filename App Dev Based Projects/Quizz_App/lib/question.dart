import 'dart:ui';

import 'package:flutter/material.dart';

class Question extends StatelessWidget {
  final String questionTxt;
  final int questionIndex;
  Question(this.questionTxt, this.questionIndex);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Color.fromRGBO(236, 232, 236, 1),
        borderRadius: BorderRadius.circular(15),
      ),
      width: double.infinity,
      height: MediaQuery.of(context).size.height * 0.10,
      margin: EdgeInsets.all(10),
      child: Container(
        padding: EdgeInsets.only(top: 8, bottom: 8),
        margin: EdgeInsets.symmetric(horizontal: 15),
        child: Center(
          child: Wrap(
            alignment: WrapAlignment.center,
            crossAxisAlignment: WrapCrossAlignment.center,
            children: [
              Text(
                "${questionIndex + 1}. $questionTxt",
                style: TextStyle(
                  fontFamily: 'Raleway',
                  fontSize: 28,
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
