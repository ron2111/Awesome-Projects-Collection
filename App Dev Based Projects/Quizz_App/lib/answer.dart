import 'package:flutter/material.dart';

class Answer extends StatefulWidget {
  final Function selectHandle;
  final Function reset;
  final String answerTxt;
  final int answerScore;
  
  Color tileColor;
  Color textColor;
  

  Answer(this.selectHandle, this.answerTxt, this.answerScore, this.tileColor,
      this.textColor, this.reset);

  @override
  State<Answer> createState() => _AnswerState();
}

class _AnswerState extends State<Answer> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: [
          Container(
            margin: EdgeInsets.all(15),
            decoration: BoxDecoration(
                color: widget.tileColor,
                borderRadius: BorderRadius.circular(15),
                border: Border.all(color: Colors.deepPurple)),
            child: ListTile(
              onTap: () {
                widget.selectHandle(widget.answerScore);

                setState(() {
                  print("set state called");
                  widget.textColor = Colors.white;
                  widget.tileColor = Colors.deepPurple;
                });
              },
              title: Center(
                child: Text(
                  widget.answerTxt,
                  style: TextStyle(fontSize: 20, color: widget.textColor),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
