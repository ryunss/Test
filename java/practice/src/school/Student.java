package school;

public class Student {
	String name;
	int room;
	int num;
	double kor;
	double math;
	double eng;
	String subj;
	int newScore;
	
	public Student() {}
	
	public Student(String name, int room, int num, double kor, double math, double eng) {
		this.name = name;
		this.room = room;
		this.num = num;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	public Student(String name, int room, int num, String subj, int newScore) {
		this.name = name;
		this.room = room;
		this.num = num;
		this.subj = subj;
		this.newScore = newScore;
	}
	
	
}
