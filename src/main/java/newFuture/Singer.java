package newFuture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @program PointsToOffer
 * @package_name newFuture
 * @description
 * @create 2020/10/12 19:33
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer {
    private String name;
    private Integer songNum;
    private Integer age;
}
