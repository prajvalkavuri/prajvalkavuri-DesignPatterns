class SingletonPattern
{ 
    private volatile static Singleton object; 
  
    private SingletonPattern() {} 
  
    public static SingletonPattern getInstance() 
    { 
        if (object == null) 
        { 
            // To make thread safe 
            synchronized (SingletonPattern.class) 
            { 
                // check again as multiple threads 
                // can reach above step 
                if (object==null) 
                    object = new SingletonPattern(); 
            } 
        } 
        return object; 
    } 
}