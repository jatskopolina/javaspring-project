package cubearticle.examples.springmvc.helpful;

public class Currency {// Валюта
	public String Name, CharCode, NumCode;

	Currency(String Name, String CharCode, String NumCode) {
		this.CharCode = CharCode;
		this.NumCode = NumCode;
		this.Name = Name;
	}
}
