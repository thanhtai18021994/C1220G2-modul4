package com.example.demo.service.position;

import com.example.demo.model.Position;
import com.example.demo.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public Page<Position> findAll(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void delete(Position position) {
        positionRepository.delete(position);
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return positionRepository.findById(id);
    }
}
