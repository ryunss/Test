function sendit() {
  const joinForm = document.joinForm;
  const userid = joinForm.userid;
  if (userid.value == "") {
    alert("아이디를 입력하세요!");
    userid.focus();
    return false;
  }
  if (userid.value.length < 5 || userid.value.length > 12) {
    alert("아이디는 5자 이상 12자 이하로 입력하세요!");
    userid.focus();
    return false;
  }

  const userpw = joinForm.userpw;
  const userpw_re = joinForm.userpw_re;

  if (userpw.value == "") {
    alert("비밀번호를 입력하세요");
    userpw.focus();
    return false;
  }
  if (userpw.value.length < 8) {
    document.getElementById("pwtxt").innerHTML =
      "비밀번호는 8자 이상으로 입력하세요!";
    userpw.focus();
    return false;
  }

  const username = joinForm.username;
  if (username.value == "") {
    alert("이름을 입력하세요!");
    username.focus();
    return false;
  }

  const exp_name = /^[가-힣]+$/;
  if (!exp_name.test(username.value)) {
    alert("이름에는 한글만 입력하세요!");
    username.focus();
    return false;
  }

  const zipcode = joinForm.zipcode;
  if (zipcode.value == "") {
    alert("주소찾기를 진행해주세요");
    sample6_execDaumPostcode();
    return false;
  }

  const addrdetail = joinForm.addrdetail;
  if (addrdetail.value == "") {
    alert("나머지 주소를 입력해주세요!");
    addrdetail.focus();
    return false;
  }

  const hobbies = joinForm.userhobby;
  let flag = false;
  for (let hobby of hobbies) {
    if (hobby.checked) {
      flag = true;
      break;
    }
  }

  if (!flag) {
    alert("취미는 적어도 1개 이상 선택해주세요");
    return false;
  }

  if (
    document.getElementById("pwtxt").innerHTML != "비밀번호가 확인되었습니다."
  ) {
    alert("비밀번호 확인을 다시 해주세요!");
    userpw.focus();
    return false;
  }

  return true;
}

function pwcheck() {
  const userpw = document.joinForm.userpw;
  const userpw_re = document.joinForm.userpw_re;

  if (userpw.value != userpw_re.value) {
    document.getElementById("pwtxt").innerHTML = "이런 오타를 내셨군요";
  } else {
    if (userpw.value == "") {
    }
    document.getElementById("pwtxt").innerHTML = "비밀번호가 확인되었습니다.";
  }
}

function sample6_execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 각 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var addr = ""; // 주소 변수
      var extraAddr = ""; // 참고항목 변수

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === "R") {
        // 사용자가 도로명 주소를 선택했을 경우
        addr = data.roadAddress;
      } else {
        // 사용자가 지번 주소를 선택했을 경우(J)
        addr = data.jibunAddress;
      }

      // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
      if (data.userSelectedType === "R") {
        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        // 건물명이 있고, 공동주택일 경우 추가한다.
        if (data.buildingName !== "" && data.apartment === "Y") {
          extraAddr +=
            extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
        }
        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
        if (extraAddr !== "") {
          extraAddr = " (" + extraAddr + ")";
        }
        // 조합된 참고항목을 해당 필드에 넣는다.
        document.getElementById("sample6_extraAddress").value = extraAddr;
      } else {
        document.getElementById("sample6_extraAddress").value = "";
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById("sample6_postcode").value = data.zonecode;
      document.getElementById("sample6_address").value = addr;
      // 커서를 상세주소 필드로 이동한다.
      document.getElementById("sample6_detailAddress").focus();
    },
  }).open();
}
