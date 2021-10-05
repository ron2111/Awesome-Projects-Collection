import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
// ignore: unused_import
import 'package:quiz_app/question.dart';
import 'package:quiz_app/result.dart';
import './quiz.dart';
import './result.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  var questionIndex = 0;

  var _totalScore = 0;

  void _resetQuiz() {
    setState(() {});
    questionIndex = 0;
    _totalScore = 0;
  }

  void answerQues(int score) {
    _totalScore += _totalScore + score;

    setState(() {
      questionIndex = questionIndex + 1;
    });

    print(questionIndex);
  }

  @override
  Widget build(BuildContext context) {
    var _questions = const [
      {
        'questions': 'What is the Italian word for "pie"?',
        'answers': [
          {'text': 'Sandwich', 'score': 0},
          {'text': 'Pizza', 'score': 20},
          {'text': 'Burger', 'score': 0},
          {'text': 'None', 'score': 0},
        ],
      },
      {
        'questions': 'What is one quarter of 1,000?',
        'answers': [
          {'text': '500', 'score': 0},
          {'text': '100', 'score': 0},
          {'text': '250', 'score': 20},
          {'text': '450', 'score': 0},
        ],
      },
      {
        'questions': 'When did the French Revolution end?',
        'answers': [
          {'text': '1788', 'score': 0},
          {'text': '1700', 'score': 0},
          {'text': '1799', 'score': 15},
          {'text': '1780', 'score': 0},
        ],
      },
    ];

    return MaterialApp(
      themeMode: ThemeMode.light,
      theme: ThemeData(primarySwatch: Colors.deepPurple, fontFamily: 'Raleway'),
      home: Scaffold(
        appBar: AppBar(
          systemOverlayStyle:
              SystemUiOverlayStyle(statusBarColor: Colors.transparent),
          brightness: Brightness.dark,
          elevation: 0,
          centerTitle: true,
          title: Text(
            "Quiz App",
            style: TextStyle(fontSize: 40, fontFamily: 'Raleway'),
          ),
        ),
        body: questionIndex < _questions.length
            ? Quiz(
                answerQues: answerQues,
                questionIndex: questionIndex,
                questions: _questions)
            : Result(_totalScore, _resetQuiz),
      ),
      debugShowCheckedModeBanner: false,
    );
  }
}
