package generator.ser.service.impl;

import generator.ser.entity.VUser;
import generator.ser.mapper.VUserMapper;
import generator.ser.service.IVUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Abraham
 * @since 2021-04-28
 */
@Service
public class VUserServiceImpl extends ServiceImpl<VUserMapper, VUser> implements IVUserService {

}
