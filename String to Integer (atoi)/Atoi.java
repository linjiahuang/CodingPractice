import java.lang.Character;

public class Atoi {

	private static final int START = 0;
	private static final int NUM = 1;
	private static final int SIGN = 2;
	private static final int GOOD_RETURN = 3;
	private static final int BAD_RETURN = 4;
	private int STATE = START;

    public int myAtoi(String str) {

    	int len = str.length();
    	int result = 1;
    	int sign = 1;

    	if (len == 0 || str == null)
    		return 0;

    	for (int i = 0; i < len; i++)
    	{
    		char c = str.charAt(i);
    		switch (STATE) {
    			case START:
    				{
    					if (Character.isWhitespace(c))
    						continue;
    					else if (Character.isDigit(c))
    					{
    						result = (int) c - 48;
    						STATE = NUM;
    					}
    					else if (c == '+')
    						STATE = SIGN;
    					else if (c == '-')
    					{
    						sign = -1;
    						STATE = SIGN;
    					}
    					else
    						STATE = BAD_RETURN;
    				}
    			break;
    			case NUM:
	    			{
						if (Character.isDigit(c))
    					{
    						result = result*10 + ((int) c - 48);
    					}
    					else
    						STATE = GOOD_RETURN;
	    			}
	    		break;
	    		case SIGN:
	    			{
						if (Character.isDigit(c))
    					{
    						result = (int) c - 48;
    						STATE = NUM;
    					}
    					else
    						STATE = BAD_RETURN;
	    			}
	    		break;
	    		case GOOD_RETURN:
	    				break;
	    		case BAD_RETURN:
	    			{
	    				result = 0;
	    				break;
	    			}
    		}
    	}

    	if (STATE == GOOD_RETURN || STATE == NUM)
    		return result * sign;
    	else
    		return 0;
    }

    public static void main(String[] args)
    {
    	Atoi test = new Atoi();

    	System.out.println(test.myAtoi(args[0]));
    }
}