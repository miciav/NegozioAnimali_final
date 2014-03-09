package it.springlesson1.negozioAnimali.DAO;

import it.springlesson1.negozioAnimali.model.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//@Repository
public class PetDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_ADD_PET = "INSERT INTO NegozioAnimali.Pets(Name,BirthDate) VALUES( ?, ?)";

	private final String SQL_SELECT_PET = "SELECT * FROM NegozioAnimali.Pets where Name = ?";

	public void AddPet(Pet p) {
		jdbcTemplate.update(SQL_ADD_PET, p.getNome(), p.getDataNascita());

	}

	public Pet GetPet(String Name) {
		return jdbcTemplate.queryForObject(SQL_SELECT_PET,
				new RowMapper<Pet>() {
					public Pet mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Pet pet = new Pet();
						pet.setNome(rs.getString(1));
						pet.setDataNascita(rs.getDate(2));
						return pet;
					}
				}, Name);

	}

}