    package com.qt.cashflow.repository;


    import com.qt.cashflow.entity.User;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        Boolean existsByUsername(String userName);
        Boolean existsByEmail(String email);

        User findOneByUsernameIgnoreCaseAndPassword(String userName, String password);
    }
