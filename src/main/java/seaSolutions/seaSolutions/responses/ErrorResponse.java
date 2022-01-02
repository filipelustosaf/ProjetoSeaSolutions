package seaSolutions.seaSolutions.responses;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {
	
	static final long serialVersionUID = 1L;
  
    private String message;
    private List<String> details;
 
}
