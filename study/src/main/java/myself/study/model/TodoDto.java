package myself.study.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TodoDto {

	private String todoContent;
	private boolean todoChecked;
	private boolean todoDeleted;
	private Date todoDate;
}
