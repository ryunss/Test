package crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CGV {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "크롬드라이버 파일경로";
	
	public static void main(String[] args) {
		WebDriver driver = null;
		
		//드라이버 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		driver = new ChromeDriver();
		
		//요청할 url
		String url = "http://www.cgv.co.kr/movies/";
		
		//요청할 url에 대한 응답페이지 열어주기
		driver.get(url);
		
		// 만약 드라이버가 작동하기 전에 어떤 요소를 찾으라고 명령을 내리게 되면 오류가 발생한다.
		// 약간의 대기시간을 통해 드라이버 작동 시간동안 시간을 벌어준다.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// btn-more-fontbold 라는 클래스를 가진 요소들을 찾고, 그 때 0번방에 있는 요소를 btn_more에 담아준다.
		// 따라서 페이지에 있는 [더보기] 버튼이 요소로 찾아져서 btn_more에 담기게 된다.
		WebElement btn_more = driver.findElements(By.className("btn-more-fontbold")).get(0);
		
		// 해당 태그가(찾아온 요소가) a, button 등 클릭 이벤트가 설정되어 있다면 click() 메소드를 통해서 요청할 수 있다.
		btn_more.click();
		
		WebElement contents = driver.findElement(By.id("contents"));
		// 가져온 요소 안에서 자식 요소를 찾고 싶다면 해당 요소 객체에 . 찍고 findElement 혹은 findElements를 써준다.
		List<WebElement> titles = contents.findElements(By.className("title"));
		
		int rank = 1;
		for(WebElement title : titles) {
			System.out.println(rank++ +". " + title.getText() );
		}
		
		// 드라이버 연결 종료
		driver.close();
		// 프로세스 종료
		driver.quit();
		
		
	}

}
