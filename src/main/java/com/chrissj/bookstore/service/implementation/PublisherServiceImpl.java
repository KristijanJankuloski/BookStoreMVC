package com.chrissj.bookstore.service.implementation;

import com.chrissj.bookstore.model.Publisher;
import com.chrissj.bookstore.model.exception.NoPublisherFoundException;
import com.chrissj.bookstore.repository.PublisherRepository;
import com.chrissj.bookstore.service.PublisherService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getById(int id) throws IOException {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NoPublisherFoundException(id));
    }

    @Override
    public Publisher add(String name, String address) {
        return publisherRepository.save(new Publisher(name, address));
    }

    @Override
    public Publisher update(int id, Publisher publisher) throws IOException {
        Publisher pUpdate = getById(id);
        pUpdate.setName(publisher.getName());
        pUpdate.setAddress(publisher.getAddress());
        return publisherRepository.save(pUpdate);
    }

    @Override
    public void deleteById(int id) throws IOException {
        Publisher pDelete = getById(id);
        publisherRepository.delete(pDelete);
    }
}
