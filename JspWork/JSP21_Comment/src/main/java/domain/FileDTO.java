package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {
	private int id; // id
	private String source; // source 원본이름
	private String file; // file 물리적으로 저장된 이름
//	private WriteDTO write; // write_id 여기선 필요없어서 안만듬
	private boolean isImage; // 이미지 여부, sql에선 없지만 필요해서 만들어줌
}
