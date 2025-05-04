package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.SendReviewRequestDto;
import com.foody.foody_project.dto.response.ReviewResponseDto;
import com.foody.foody_project.model.ReceiverType;
import com.foody.foody_project.model.Review;
import com.foody.foody_project.service.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReviewConverter {

    public final UserService userService;

    public ReviewConverter(UserService userService) {
        this.userService = userService;
    }

    public Review toEntityFromSendReviewRequestDtoFood(SendReviewRequestDto requestDto) {
        Review entity = new Review();
        entity.setReviewText(requestDto.getReviewText());
        entity.setSenderUserId(requestDto.getSenderUserId());
        entity.setReceiverId(requestDto.getReceiverId());
        entity.setReceiverType(ReceiverType.FOOD);
        entity.setReviewDate(LocalDate.now());
        entity.setReviewStatus(true);
        entity.setReviewPoint(requestDto.getReviewPoint());

        return entity;
    }

    public Review toEntityFromSendReviewRequestDtoRestaurant(SendReviewRequestDto requestDto) {
        Review entity = new Review();
        entity.setReviewText(requestDto.getReviewText());
        entity.setSenderUserId(requestDto.getSenderUserId());
        entity.setReceiverId(requestDto.getReceiverId());
        entity.setReceiverType(ReceiverType.RESTAURANT);
        entity.setReviewDate(LocalDate.now());
        entity.setReviewStatus(true);
        entity.setReviewPoint(requestDto.getReviewPoint());

        return entity;
    }

    public ReviewResponseDto toReviewResponseDtoFromEntity(Review entity) {
        return new ReviewResponseDto(
                entity.getReviewText(),
                userService.getUsernameAndPhotoById(entity.getSenderUserId()).getFullName(),
                userService.getUsernameAndPhotoById(entity.getSenderUserId()).getPhoto(),
                entity.getReviewDate(),
                entity.getReviewPoint()
        );
    }
}
