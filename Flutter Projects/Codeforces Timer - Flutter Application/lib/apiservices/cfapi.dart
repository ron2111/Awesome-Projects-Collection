import 'package:codeforces_contest/models/codeforcescontest.dart';
import 'package:flutter/material.dart';
import 'package:dio/dio.dart';

class codeforcesApiServices{
  final String apiUrl = 'https://codeforces.com/api/contest.list';
  Dio _dio;
   codeforcesApiServices(){
    _dio = Dio();
  }


  // Fetch ongoing contest list
  Future<List<Result>> fetchOngoingContestList()async{
     try{
       Response response = await _dio.get(apiUrl);
       Codeforcescontest contest = Codeforcescontest.fromJson(response.data);
       return contest.result.where((element) => element.phase==Phase.CODING).toList().reversed.toList();
     }
     on DioError{
       return null;
     }
  }

  // Fetch upcoming contest list

  Future<List<Result>> fetchUpcomingContestList()async{
    try{
      Response response = await _dio.get(apiUrl);
      Codeforcescontest contest = Codeforcescontest.fromJson(response.data);
      return contest.result.where((element) => element.phase==Phase.BEFORE).toList().reversed.toList();
    }
    on DioError{
      return null;
    }
  }

}