package pl.sda.jira.forum.domain;

import org.springframework.stereotype.Repository;

@Repository
public class JpaDataForumRepository implements ForumRepository {
    private final CrudJpaForumRepository repository;

    public JpaDataForumRepository(CrudJpaForumRepository repository) {
        this.repository = repository;
    }

    @Override
    public Forum get(long forumId) {
        return repository.findOne(forumId);
    }

    @Override
    public boolean exists(long forumId) {
        return repository.exists(forumId);
    }

    @Override
    public Forum add(Forum forum) {
        return repository.save(forum);
    }

    @Override
    public void remove(long forumId) {
        repository.delete(forumId);
    }

    @Override
    public void replace(Forum forum) {
        repository.save(forum);
    }
}