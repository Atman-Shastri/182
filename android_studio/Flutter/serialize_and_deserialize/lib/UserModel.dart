class UserModel {
  late String id, fullname, email, percentage;

  UserModel(
      {required this.id,
      required this.fullname,
      required this.email,
      required this.percentage});

  UserModel.fromMap(Map<String, dynamic> map) {
    this.id = map["id"];
    this.fullname = map["fullname"];
    this.email = map["email"];
    this.percentage = map["percentage"];
  }

  Map<String, dynamic> toMap() {
    return {
      "id": this.id,
      "fullname": this.fullname,
      "email": this.email,
      "percentage": this.percentage,
    };
  }
}
