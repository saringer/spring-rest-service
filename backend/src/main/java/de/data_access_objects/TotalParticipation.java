package de.data_access_objects;

public class TotalParticipation {

        public TotalParticipation(Long dog_id, String name, Long total_participation) {
            this.name = name;
            this.dog_id = dog_id;
            this.total_participation = total_participation;
        }

        public Long getDog_id() {
            return dog_id;
        }

        public void setDog_id(Long dog_id) {
            this.dog_id = dog_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getTotal_participation() {
            return total_participation;
        }

        public void setTotal_participation(Long total_participation) {
            this.total_participation = total_participation;
        }

        Long dog_id;
        String name;
        Long total_participation;


}
