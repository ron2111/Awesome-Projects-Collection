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
      resultText = "Sorry... you did not score well !";
    }

    return resultText;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: double.infinity,
      width: double.infinity,
      decoration: BoxDecoration(
          gradient: LinearGradient(
              colors: [Colors.deepPurple, Color.fromRGBO(176, 74, 243, 1)],
              begin: Alignment.topCenter,
              end: Alignment.bottomCenter)),
      child: Column(
        children: <Widget>[
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.08,
          ),
          Wrap(children: [
            Text(
              resultPhrase,
              style: TextStyle(
                color: Color.fromRGBO(236, 232, 236, 1),
                fontSize: 36,
                fontWeight: FontWeight.bold,
              ),
              textAlign: TextAlign.center,
            ),
          ]),
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.2,
          ),
          TextButton(
            child: Text(
              'Restart Quizz!',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 35),
            ),
            style: ButtonStyle(
                foregroundColor:
                    MaterialStateProperty.all(Colors.orangeAccent)),
            onPressed: resetHandler,
          ),
        ],
      ),
    );
  }
}
