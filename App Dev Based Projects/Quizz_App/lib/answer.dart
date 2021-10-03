import 'package:flutter/material.dart';

class Answer extends StatelessWidget {
  final Function selectHandle;
  final String answerTxt;
  Answer(this.selectHandle, this.answerTxt);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(primary: Colors.blue),
        child: Text(answerTxt),
        onPressed: selectHandle,
      ),
    );
  }
}
