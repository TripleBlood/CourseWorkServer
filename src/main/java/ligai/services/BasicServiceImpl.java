package ligai.services;

import ligai.models.User;
import ligai.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

}
