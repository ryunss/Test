package school;

public class Manager {
	Student[] arStudent = new Student[1000];
	int cnt;
	String result = "";
	
	// 등록
	void insert(String name, int room, int num, double kor, double math, double eng) {
		Student newStudent = new Student(name, room, num, kor, math, eng);
		arStudent[cnt] = newStudent;
		cnt++;
		
//		arStudent[cnt++] = new Student(name, room, num, kor, math, eng);
	}

	// 조회
	public String search(int room, int num) {
		Student st = null;
		for (int i = 0; i < cnt; i++) {
			if(arStudent[i].room == room && arStudent[i].num == num) {
				st = arStudent[i];
				break;
			}
		}
		
		if(st == null) {
			result = "반 번호를 잘못 입력하셨습니다.";
		}else {
			result += String.format("-------%s 학생의 정보-------\n", st.name);
			result += String.format("국어점수 : %.2f\n", st.kor);
			result += String.format("수학점수 : %.2f\n", st.math);
			result += String.format("영어점수 : %.2f\n", st.eng);
			double sum = st.kor + st.math + st.eng;
			result += String.format("총점 : %.2f점 / 평균 : %.2f점", sum, sum/3);
		}
		
		return result;
	}

	// 수정
	public String update(int room, int num, String subj, int newScore) {
		Student st = null;
		if(!(subj.equals("수학") || subj.equals("영어") || subj.equals("국어"))) {
			result = "과목 입력이 제대로 되지 않았습니다. 국어, 영어, 수학 중 하나를 입력해주세요";
			return result;
		}
			
		for (int i = 0; i < cnt; i++) {
			if(arStudent[i].room == room && arStudent[i].num == num) {
				if("영어".equals(subj)) {
					arStudent[i].eng = newScore;
				}else if("수학".equals(subj)) {
					arStudent[i].math = newScore;
				}else if("국어".equals(subj)) {
					arStudent[i].kor = newScore;
				}
				st = arStudent[i];
				break;
			}
		}
		if(st == null) {
			result = "반 번호를 잘못 입력하셨습니다.";
		}else {
			result = "수정이 완료되었습니다.";
		}
		
		return result;
	}

	public String delete(int room, int num) {
		int idx = -1;
		for (int i = 0; i < cnt; i++) {
			if(arStudent[i].room == room && arStudent[i].num == num) {
				idx = i;
				break;
			}
		}
		
		String result = "";
		if(idx == -1) { // 해당하는 반, 번호가 없다. 즉 지울게 없다는거
			result = "반 번호를 잘못 입력하셨습니다";
		}else {
			if(idx == cnt-1) {// 마지막 방인지 확인
				arStudent[idx] = null; // 마지막이 맞으면 그 방을 null 로 만들어서 지움.
			}else {
				for(int i=idx; i<cnt-1; i++) {
					arStudent[i] = arStudent[i+1];
				}
				arStudent[cnt-1] = null;
			}
			result = "자퇴했습니다";
			cnt--;
		}
		return result;
	}	
}
