package br.net.trabalho.api.repository;

import br.net.trabalho.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findByEmail(String email);

    @Query("from Cliente where email = :email and senha = :senha")
    public Cliente findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
