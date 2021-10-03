import 'package:flutter/material.dart';

class Result extends StatelessWidget {
  final int result;
  final Function resetHandler;
  Result(this.result, this.resetHandler);

  String get resultPhrase {
    var resultText = "You did it";
    if (result >= 40) {
      resultText = 'You are awesome!';
    } else if (result > 10 && result < 40) {
      resultText = "Better luck next time!";
    } else {
      resultText = "Sorry... you did not score well";
    }

    return resultText;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(
        children: <Widget>[
          Text(
            resultPhrase,
            style: TextStyle(
              fontSize: 36,
              fontWeight: FontWeight.bold,
            ),
            textAlign: TextAlign.center,
          ),
          TextButton(
            child: Text('Restart Quizz!',textAlign: TextAlign.center,),
            style: ButtonStyle(
                foregroundColor: MaterialStateProperty.all(Colors.orangeAccent)),
            onPressed: resetHandler,
          ),
        ],
      ),
    );
  }
}
