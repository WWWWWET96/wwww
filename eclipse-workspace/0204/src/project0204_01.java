import java.util.HashMap;

/*문제 설명
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

종류	이름
얼굴	동그란 안경, 검정 선글라스
상의	파란색 티셔츠
하의	청바지
겉옷	긴 코트
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
스파이는 하루에 최소 한 개의 의상은 입습니다.
입출력 예
clothes	return
[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
입출력 예 설명
예제 #1
headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.

1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses
예제 #2
face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.

1. crow_mask
2. blue_sunglasses
3. smoky_makeup

* 2차원 배열 [][1]이것만 비교하면 되는 것. 
* 일단 처음엔 하나씩 다 나오니까 answer는 배열의 길이만큼 ++
* 그 후 조합들 찾아야함
* 반복문 통해 boolean containsValue해서 value(headgear, face..)확인. false반환한 것들과 조합할 수 있으니까
* 혹은 그 옷을 반환해야하는게 아니니까 전체를 다 돌면서 구분짓는거? 헤드기어끼리, eyewear끼리 구분지어서
* 숫자로 체킹한 후 그 숫자들의 경우의 수를 구하면 되지않을까
* 
* 

*/

class Solution0204_01{
	static int count(HashMap<String, Integer> wear, int answer) {
		for(int j:wear.values()) {/*지은이가 푼거
* (x+1) * (y+1) - 1
* -> +1해주는 경우는 상의만 입거나 하의만 입거나 하는 경우있으니가 옷 하나 더있다고 생각
* 마지막 -1은 아예 안입는 경우는 없다고했으니까
상의 2개. 하의 4개 겉옷 1
3*5*2 -1*/
			answer = answer *(j+1);
		}
		answer = answer-1;
		
		return answer;
	}
	static int solution0204_01(String[][] clothes) {
		int answer=1;
		
		HashMap<String, Integer> wear = new HashMap<>();
		String[] temp = new String[clothes.length];

		for(int i =0; i<clothes.length; i++) {
			temp[i]= clothes[i][1];
		}
		for(String s : temp) {
			wear.put(s, wear.getOrDefault(s, 0)+1);//카운트 세는거니까 +1
			//﻿getOrDefault(Obeject key, Integer defaultValue)는 원하는 key있으면 1 반환, 없으면 0반환인듯
		}
		System.out.println(wear);
		
		return count(wear, answer);
				
	}
}
public class project0204_01 extends Solution0204_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellow_hat","headgear"}, {"blue_sunglasses","eyewear"},
				{"green_turban", "headgear"}};
		
		System.out.println(solution0204_01(clothes));
}
		                    
				
		
	}

