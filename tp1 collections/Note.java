
public class Note implements Comparable<Note> {
	private String intituleCours;
	public float note;
	
	public Note(String intituleCours, float note) {
		this. intituleCours= intituleCours;
		this.note = note;
	}

	
	public void setNote(float note) {
		this.note = note;
	}

	public float getNote() {
	
		return note;
	}
	
	@Override
	
	public int compareTo(Note o) {
	    return Float.compare(this.getValue(), o.getValue());
	}


	public float getValue() {
		
		return note;
	}


	@Override
	public String toString() {
		return "Note [intituleCours=" + intituleCours + ", note=" + note + "]";
	}

}
