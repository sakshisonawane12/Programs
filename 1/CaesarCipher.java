class CaesarCipher
{
    
    private String alphabet;
    private  String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key)
    {
        alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
        

    }

    public String encrypt(String input)
    {
        StringBuilder encrypted=new StringBuilder(input);

        for(int i=0;i<encrypted.length();i++)
        {
            char currChar=encrypted.charAt(i);
            boolean isLower=Character.isLowerCase(currChar);
            char upperChar=Character.toUpperCase(currChar);
            int idx=alphabet.indexOf(upperChar);

            if(idx !=-1)
            {
                char newChar=shiftedAlphabet.charAt(idx);
                if(isLower)
                {
                    newChar=Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
public String decrypt(String input)
{
    CaesarCipher cc=new CaesarCipher(26-mainKey);
    return cc.encrypt(input);
}



}