package com.social.media.config;

import com.social.media.entity.Post;
import com.social.media.entity.Profile;
import com.social.media.entity.SocialGroup;
import com.social.media.entity.User;
import com.social.media.repository.PostRepository;
import com.social.media.repository.ProfileRepository;
import com.social.media.repository.SocialGroupRepository;
import com.social.media.repository.SocialUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class DataInitializer {

    private final SocialUserRepository socialUserRepository;
    private final ProfileRepository profileRepository;
    private final PostRepository postRepository;
    private final SocialGroupRepository socialGroupRepository;


    @Bean
    public CommandLineRunner initialData(){
        return args -> {
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            SocialGroup socialGroup1 = new SocialGroup();
            SocialGroup socialGroup2 = new SocialGroup();

            socialGroup1.getUser().add(user1);
            socialGroup2.getUser().add(user2);
            socialGroup1.getUser().add(user3);

            socialGroupRepository.save(socialGroup1);
            socialGroupRepository.save(socialGroup2);

            user1.getGroups().add(socialGroup1);
            user2.getGroups().add(socialGroup2);
            user3.getGroups().add(socialGroup1);

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            Profile profile1 = new Profile();
            Profile profile2 = new Profile();
            Profile profile3 = new Profile();

            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            profileRepository.save(profile1);
            profileRepository.save(profile2);
            profileRepository.save(profile3);




        };

    }

}
