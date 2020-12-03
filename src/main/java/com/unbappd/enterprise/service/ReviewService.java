package com.unbappd.enterprise.service;

import com.unbappd.enterprise.dao.IReviewDAO;
import com.unbappd.enterprise.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *performs the methods for the service
 */

@Service
public class ReviewService implements IReviewService {
    @Autowired
    public IReviewDAO reviewDAO;

    @Override
    public Review save(Review review) throws Exception {
        reviewDAO.save(review);
        return review;
    }

    @Override
    public Review fetchById(int placeID) {
        return reviewDAO.fetchById(placeID);
    }

    @Override
    public List<Review> fetchAll() {
        return reviewDAO.fetchAll();
    }

    public void cheers(int reviewId) {
        this.reviewDAO.cheers(reviewId);
    }
    @Override
    public void saveImage(MultipartFile imageFile, String id) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        String folder = absolutePath.toString().replaceAll(".","") + "src\\main\\resources\\static\\";
        System.out.println(folder);
        byte[] bytes = imageFile.getBytes();
        String reg = "image\\";
        Path path = Paths.get(folder + id + "." + imageFile.getContentType().substring(6, imageFile.getContentType().length()));
        Files.write(path, bytes);
    }

}
