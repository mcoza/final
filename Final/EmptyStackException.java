package Final;


public class EmptyStackException extends RuntimeException
{
   public EmptyStackException()
   {
      this(null);
   } // end default constructor
   
   public EmptyStackException(String message)
   {
      super(message);
   } // end constructor
} // end EmptyStackException