package srt.heavy.task.tasks;

import org.springframework.stereotype.Component;

@Component
public class HighestCommonFactorCalculator implements Task<Long> {

    @Override
    public boolean execute(Long number) {
        long hcf = -1;
        for (long i = 2; i < number - 1; i++) {
            if(number % i == 0)
                hcf = i;
        }
        return hcf != -1;
    }
}
