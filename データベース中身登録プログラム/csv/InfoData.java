package csv;

public class InfoData {
	private String wordscate;//言葉カテゴリ
	private String cocktail;//カクテル名
	private String words;//カクテル言葉
	private String imageURL;//画像URL
	private String howto;//作り方
	private String material;//材料

	protected InfoData(String wordscate,String coctail,String words) {
		setWordscate(wordscate);
		setCocktail(coctail);
		setWords(words);
	}

	protected InfoData(String wordscate,String coctail,String words,String imageURL,String howto,String material) {
		setWordscate(wordscate);
		setCocktail(coctail);
		setWords(words);
		setImageURL(imageURL);
		setHowto(howto);
		setMaterial(material);
	}

	public String getWordscate() {
		return wordscate;
	}

	public void setWordscate(String wordscate) {
		this.wordscate = wordscate;
	}

	public String getCocktail() {
		return cocktail;
	}

	public void setCocktail(String cocktail) {
		this.cocktail = cocktail;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getHowto() {
		return howto;
	}

	public void setHowto(String howto) {
		this.howto = howto;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void show() {
		System.out.println(getWordscate()+getCocktail()+getWords());
	}
	public void show2() {
		System.out.println(getWordscate()+getCocktail()+getWords()+getImageURL()+getHowto()+getMaterial());
	}
}
