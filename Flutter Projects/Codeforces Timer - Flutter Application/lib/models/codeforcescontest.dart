class Codeforcescontest {
  Codeforcescontest({
    this.status,
    this.result,
  });

  String status;
  List<Result> result;

  factory Codeforcescontest.fromJson(Map<String, dynamic> json) => Codeforcescontest(
    status: json["status"],
    result: List<Result>.from(json["result"].map((x) => Result.fromJson(x))),
  );

  Map<String, dynamic> toJson() => {
    "status": status,
    "result": List<dynamic>.from(result.map((x) => x.toJson())),
  };
}

class Result {
  Result({
    this.id,
    this.name,
    this.type,
    this.phase,
    this.frozen,
    this.durationSeconds,
    this.startTimeSeconds,
    this.relativeTimeSeconds,
  });

  int id;
  String name;
  Type type;
  Phase phase;
  bool frozen;
  int durationSeconds;
  int startTimeSeconds;
  int relativeTimeSeconds;

  factory Result.fromJson(Map<String, dynamic> json) => Result(
    id: json["id"],
    name: json["name"],
    type: typeValues.map[json["type"]],
    phase: phaseValues.map[json["phase"]],
    frozen: json["frozen"],
    durationSeconds: json["durationSeconds"],
    startTimeSeconds: json["startTimeSeconds"],
    relativeTimeSeconds: json["relativeTimeSeconds"],
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "name": name,
    "type": typeValues.reverse[type],
    "phase": phaseValues.reverse[phase],
    "frozen": frozen,
    "durationSeconds": durationSeconds,
    "startTimeSeconds": startTimeSeconds,
    "relativeTimeSeconds": relativeTimeSeconds,
  };
}

enum Phase { BEFORE, CODING, FINISHED, PENDING_SYSTEM_TEST }

final phaseValues = EnumValues({
  "BEFORE": Phase.BEFORE,
  "CODING": Phase.CODING,
  "FINISHED": Phase.FINISHED,
  "PENDING_SYSTEM_TEST": Phase.PENDING_SYSTEM_TEST
});

enum Type { CF, ICPC, IOI }

final typeValues = EnumValues({
  "CF": Type.CF,
  "ICPC": Type.ICPC,
  "IOI": Type.IOI
});

class EnumValues<T> {
  Map<String, T> map;
  Map<T, String> reverseMap;

  EnumValues(this.map);

  Map<T, String> get reverse {
    if (reverseMap == null) {
      reverseMap = map.map((k, v) => new MapEntry(v, k));
    }
    return reverseMap;
  }
}
