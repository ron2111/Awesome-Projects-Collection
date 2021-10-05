import 'package:flutter/material.dart';
import './answer.dart';
import './question.dart';

class Quiz extends StatefulWidget {
  final List<Map<String, Object>> questions;
  final int questionIndex;
  final Function answerQues;

  Quiz(
      {@required this.questions,
      @required this.answerQues,
      @required this.questionIndex});

  @override
  State<Quiz> createState() => _QuizState();
}

class _QuizState extends State<Quiz> {
  var score;
  var listTileColor = Colors.transparent;
  var listTileTextColor = Colors.black;
  var choosen = false;
  void changeQuestion(int sc) {
    widget.answerQues(sc);
  }

  void getScore(int sc) {
    score = sc;
  }

  void changeColors() {
    listTileColor = Colors.transparent;
    listTileTextColor = Colors.black;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
          gradient: LinearGradient(
              colors: [Colors.deepPurple, Color.fromRGBO(176, 74, 243, 1)],
              begin: Alignment.topCenter,
              end: Alignment.bottomCenter)),
      height: double.infinity,
      child:
          Column(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
        SizedBox(
          height: MediaQuery.of(context).size.height * 0.05,
        ),
        Question(widget.questions[widget.questionIndex]['questions'],
            widget.questionIndex),
        SizedBox(
          height: MediaQuery.of(context).size.height * 0.05,
        ),
        Container(
          padding: EdgeInsets.only(top: 30),
          margin: EdgeInsets.only(left: 30, right: 30, top: 30),
          decoration: BoxDecoration(
              color: Color.fromRGBO(236, 232, 236, 1),
              // border: Border.all(ss),
              borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20), topRight: Radius.circular(20))),
          height: MediaQuery.of(context).size.height * 0.6,
          width: double.infinity,
          child: Column(
            children: [
              Container(
                height: MediaQuery.of(context).size.height * 0.4,
                child: ListView(
                  children: (widget.questions[widget.questionIndex]['answers']
                          as List<Map<String, Object>>)
                      .map((answer) {
                    return Answer(
                      getScore,
                      answer['text'],
                      answer['score'],
                      listTileColor,
                      listTileTextColor,
                      changeColors,
                    );
                  }).toList(),
                ),
              ),
              Container(
                width: MediaQuery.of(context).size.width * 0.30,
                child: ElevatedButton(
                  onPressed: () {
                    changeQuestion(score);
                    setState(() {
                      changeColors();
                    });
                  },
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      Text(
                        "Submit",
                        style: TextStyle(fontSize: 22, color: Colors.white),
                      ),
                      Icon(Icons.arrow_forward_ios_rounded,
                          color: Colors.white),
                    ],
                  ),
                ),
              )
            ],
          ),
        ),
      ]),
    );
  }
}
