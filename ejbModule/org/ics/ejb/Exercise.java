package org.ics.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Exercise.findAll", 
			query="SELECT e FROM Exercise e"),
	@NamedQuery(name="Exercise.findByName", 
			query="SELECT e FROM Exercise e WHERE e.name LIKE :name")
})

@Entity
@Table(name="Exercise")
//@SequenceGenerator(name="ID_SEQ", allocationSize=1)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Exercise implements Serializable {

	private static final long serialVersionUID = -3715366092534466876L;
	private long exId;
	private String name;
	private String descr;
	private String ex_type;
	private Set<ExerciseRow>exerciseRows2; //Exercise kan finnas i många exerciseRows ??
	
	//Alternativt ta bort generatedValue...
	@Id
	@SequenceGenerator(name = "b1_seq", sequenceName = "b1_seq", allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b1_seq")
	@Column(name="exId")
	public long getExId(){
		return exId;
	}
	
	public void setExId(long exId){
		this.exId = exId;
	}
	
	@Column(name="Name")
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name="Description")
	public String getDescr(){
		return descr;
	}
	
	public void setDescr(String descr){
		this.descr = descr;
	}
	
	@Column(name="ex_type")
	public String getEx_type(){
		return ex_type;
	}
	
	public void setEx_type(String ex_type){
		this.ex_type = ex_type;
	}
	
	@OneToMany(mappedBy="exercise", fetch=FetchType.EAGER)//övningens övningsrader följer INTE med när övning blir managed.
	public Set<ExerciseRow>getExerciseRows2(){
		return exerciseRows2;
	}
	
	public void setExerciseRows2(Set<ExerciseRow>exerciseRows2){
		this.exerciseRows2 = exerciseRows2;
	}
}
