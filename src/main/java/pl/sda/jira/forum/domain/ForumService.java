package pl.sda.jira.forum.domain;

public class ForumService {

    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public ForumDto get(int forumId) {
        if(forumRepository.exists(forumId)){
            return forumRepository.get(forumId).asDto() ;
        }else {
            throw new ForumDoesNotExistExcepton();
        }
    }

}