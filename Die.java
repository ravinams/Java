class Die {
	
	static final int HIGHEST_DIE_VALUE = 6; // higest value
	static final int LOWEST_DIE_VALUE = 1; // lowest value
	
	int value ;

	Die()
	{
		value = ((int)(Math.random() * 100) % HIGHEST_DIE_VALUE +	LOWEST_DIE_VALUE);
	}
	// returns the random integer that was calculated above
	public int getDieValue() {
		return value;
	}	
	
}